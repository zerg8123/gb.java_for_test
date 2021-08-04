package HomeWork_7;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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

                Double averageTemperature = (oneDayTemperatureMinJsonKey + oneDayTemperatureMaxJsonKey) / 2;
                Double averageTemperatureCelsius = (averageTemperature - 32) / 1.8;

                System.out.printf("Средняя температура за день в городе %s - %s%s - %.2fС, Сегодня %s%n",
                        selectedCity, averageTemperature, oneDaySymbolTemperatureJsonKey,
                        averageTemperatureCelsius, oneDayDateJsonKey);

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

                    Double fiveDayAverageTemperature = (fiveDayTemperatureMinJsonKey + fiveDayTemperatureMaxJsonKey) / 2;

                    Double fiveDayAverageTemperatureCelsius = (fiveDayAverageTemperature - 32) / 1.8;
                    String fiveDayDateJsonKey = objectMapper
                            .readTree(fiveDayWeatherResponse)
                            .at(DAILY_FORECAST).get(i).at(TEMPERATURE_DATE).asText();

                    System.out.printf("Средняя температура за %s в городе %s - %s%s - %.2fC%n",
                            fiveDayDateJsonKey, selectedCity, fiveDayAverageTemperature,
                            fiveDaySymbolTemperatureJsonKey, fiveDayAverageTemperatureCelsius);
                }
                break;
        }
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
