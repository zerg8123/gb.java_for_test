package HomeWork_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public class GlobalParam {
    static final String PROTOCOL = "http";
    static final String BASE_HOST = "dataservice.accuweather.com";
    static final String FORECAST = "forecasts";
    static final String VERSION = "v1";
    static final String DAILY = "daily";

    static final String ONE_DAY = "1day";
    static final String FIVE_DAYS = "5day";

    static final String LOCATIONS = "locations";
    static final String CITIES = "cities";
    static final String AUTOCOMPLETE = "autocomplete";

    static final String API_KEY = "GKmeVEbpgmin9bAU8tZGPqZr9heditoP";
    static final String API_KEY_QUERY_PARAM = "apikey";

    static final String LANGUAGE_RU = "ru-RU";
    static final String LANGUAGE_QUERY_PARAM = "language";

    static final String HEADER_ACCEPT_QUERY_PARAM = "accept";
    static final String HEADER_ACCEPT = "application/json";

    static final String DAILY_FORECAST = "/DailyForecasts";
    static final String HEADLINE_TEXT = "/Headline/Text";

    static final String TEMPERATURE_MIN_VALUE = "/Temperature/Minimum/Value";
    static final String TEMPERATURE_MIN_UNIT = "/Temperature/Minimum/Unit";
    static final String TEMPERATURE_MAX_VALUE = "/Temperature/Maximum/Value";
    static final String TEMPERATURE_DATE = "/Date";

    static final String AUTOCOMPLETE_KEY_CITY = "/Key";
    static final String AUTOCOMPLETE_Q_QUERY_PARAM = "q";

    static final OkHttpClient okHttpClient = new OkHttpClient();
    static final ObjectMapper objectMapper = new ObjectMapper();
}
