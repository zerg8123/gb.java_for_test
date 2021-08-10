package HomeWork_7.AcuuWeather;

import HomeWork_7.AcuuWeather.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherModel extends GlobalParam implements WeatherModel {

    public void getWeather(String selectedCity, Period period) throws IOException {

        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectedCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_RU)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .get()
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String oneDayWeatherResponse = oneDayForecastResponse.body().string();
                String oneDayDateJsonKey = objectMapper.readTree(oneDayWeatherResponse).at(HEADLINE_TEXT).asText();

                Double oneDayTemperatureMinJsonKey = objectMapper
                        .readTree(oneDayWeatherResponse)
                        .at(DAILY_FORECAST).get(0).at(TEMPERATURE_MIN_VALUE).asDouble();

                Double oneDayTemperatureMaxJsonKey = objectMapper
                        .readTree(oneDayWeatherResponse)
                        .at(DAILY_FORECAST).get(0).at(TEMPERATURE_MAX_VALUE).asDouble();

                String oneDaySymbolTemperatureJsonKey = objectMapper
                        .readTree(oneDayWeatherResponse)
                        .at(DAILY_FORECAST).get(0).at(TEMPERATURE_MIN_UNIT).asText();

                Double methodAverageTemperature = oneDayAverageTemperature(oneDayTemperatureMinJsonKey, oneDayTemperatureMaxJsonKey);
                Double methodAverageTemperatureCelsius = OneDayAverageTemperatureCelsius(methodAverageTemperature);

                System.out.printf("Средняя температура за день в городе %s - %s%s - %.2fС, Сегодня %s%n",
                        selectedCity, methodAverageTemperature, oneDaySymbolTemperatureJsonKey,
                        methodAverageTemperatureCelsius, oneDayDateJsonKey);

                try {
                    dataBaseRepository.saveWeatherToDataBase(
                            new Weather(selectedCity, oneDayDateJsonKey, methodAverageTemperatureCelsius));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case FIVE_DAYS:
                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectedCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_RU)
                        .build();

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .get()
                        .addHeader(HEADER_ACCEPT_QUERY_PARAM, HEADER_ACCEPT)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                String fiveDayWeatherResponse = fiveDayForecastResponse.body().string();


                for (int i = 0; i < 5; i++) {
                    Double fiveDayTemperatureMinJsonKey = objectMapper
                            .readTree(fiveDayWeatherResponse)
                            .at(DAILY_FORECAST).get(i).at(TEMPERATURE_MIN_VALUE).asDouble();

                    Double fiveDayTemperatureMaxJsonKey = objectMapper
                            .readTree(fiveDayWeatherResponse)
                            .at(DAILY_FORECAST).get(i).at(TEMPERATURE_MAX_VALUE).asDouble();

                    String fiveDaySymbolTemperatureJsonKey = objectMapper
                            .readTree(fiveDayWeatherResponse)
                            .at(DAILY_FORECAST).get(i).at(TEMPERATURE_MIN_UNIT).asText();

                    String fiveDayDateJsonKey = objectMapper
                            .readTree(fiveDayWeatherResponse)
                            .at(DAILY_FORECAST).get(i).at(TEMPERATURE_DATE).asText();

                    Double methodFiveDayAverageTemperature = fiveDayAverageTemperature(fiveDayTemperatureMinJsonKey,
                            fiveDayTemperatureMaxJsonKey);
                    Double methodFiveDayAverageTemperatureCelsius = fiveDayAverageTemperatureCelsius
                            (methodFiveDayAverageTemperature);

                    System.out.printf("Средняя температура за %s в городе %s - %s%s - %.2fC%n",
                            fiveDayDateJsonKey, selectedCity, methodFiveDayAverageTemperature,
                            fiveDaySymbolTemperatureJsonKey, methodFiveDayAverageTemperatureCelsius);
                }
                break;

            case YA:
                HttpUrl httpUrl2 = new HttpUrl.Builder()
                        .scheme(PROTOCOL_HTTPS)
                        .host(BASE_HOST_YA)
                        .addPathSegment(VERSION_YA)
                        .addPathSegment(INFORMERS)
                        .addQueryParameter(LAT_QUERY_PARAM, LAT)
                        .addQueryParameter(LON_QUERY_PARAM, LON)
                        .build();


                Request request2 = new Request.Builder()
                        .url(httpUrl2)
                        .addHeader(API_KEY_YA_QUERY_PARAM, API_KEY_YA)
                        .get()
                        .build();

                Response YaForecastResponse = okHttpClient.newCall(request2).execute();
                String responseString = YaForecastResponse.body().string();

                String yaDateJsonText = objectMapper
                        .readTree(responseString)
                        .at(FORECAST_DATE_YA).asText();

                Integer yaTemperatureJsonInteger = objectMapper
                        .readTree(responseString)
                        .at(TEMPERATURE_YA).asInt();

                System.out.printf("%s - температура на данный момент - %s%n", yaDateJsonText, yaTemperatureJsonInteger);

                break;
        }
    }

    @Override
    public List<Weather> getSaveToDBWeather() {
        return dataBaseRepository.getSaveToDBWeather();
    }


    private static Double oneDayAverageTemperature(Double oneDayTemperatureMinJsonKey, Double oneDayTemperatureMaxJsonKey) {
        return (oneDayTemperatureMinJsonKey + oneDayTemperatureMaxJsonKey) / 2;
    }

    private static Double OneDayAverageTemperatureCelsius(Double oneDayAverageTemperature) {
        return (oneDayAverageTemperature - 32) / 1.8;
    }

    private static Double fiveDayAverageTemperature(Double fiveDayTemperatureMinJsonKey, Double fiveDayTemperatureMaxJsonKey) {
        return (fiveDayTemperatureMinJsonKey + fiveDayTemperatureMaxJsonKey) / 2;
    }

    private static Double fiveDayAverageTemperatureCelsius(Double fiveDayAverageTemperature) {
        return (fiveDayAverageTemperature - 32) / 1.8;
    }

    private static String detectedCityKey(String selectedCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(AUTOCOMPLETE_Q_QUERY_PARAM, selectedCity)
                .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE_RU)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader(HEADER_ACCEPT_QUERY_PARAM, HEADER_ACCEPT)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at(AUTOCOMPLETE_KEY_CITY).asText();
        return cityKey;
    }

}
