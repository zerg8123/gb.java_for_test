package HomeWork_6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AppAccuWeather {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String LOCATION = "294021";
    private static final String API_KEY = "9IFPgxzRnKSdHNX7ADckm5TxMiG88y6S";
    private static final String API_KEY_QUERY_PARAM = "apikey";

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void getWeather (String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(ONE_DAY)
                .addPathSegment(LOCATION)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("Content-Type","application/json")
                .build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayForecastResponse.body().string();
        System.out.println(weatherResponse);

    }

    public static void main(String[] args) throws IOException {
        getWeather("Moscow");
    }
}
