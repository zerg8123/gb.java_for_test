package HomeWork_7.AcuuWeather;

import HomeWork_7.AcuuWeather.entity.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;

    public List<Weather> getSaveToDBWeather();
}
