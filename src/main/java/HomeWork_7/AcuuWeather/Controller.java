package HomeWork_7.AcuuWeather;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuWeatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
        variants.put(2, Period.BD);
        variants.put(3, Period.YA);
    }

    public void getWeather(String userInput, String selectCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectCity, Period.FIVE_DAYS);
                break;
            case BD:
                weatherModel.getSaveToDBWeather();
                break;
            case YA:
                weatherModel.getWeather(selectCity, Period.YA);
                break;
        }
    }
}
