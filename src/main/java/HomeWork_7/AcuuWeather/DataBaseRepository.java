package HomeWork_7.AcuuWeather;

import HomeWork_7.AcuuWeather.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository extends GlobalParam {
    private String insertWeather = "insert into accuWeather(city, localDate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from accuWeather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public List<Weather> getSaveToDBWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                String localDate = resultSet.getString("localDate");
                Double temperature = resultSet.getDouble("temperature");
                System.out.printf("id: %s, city: %s, localDate: %s, temperature: %.2f%n",
                        id, city, localDate, temperature);
                weathers.add(new Weather(city, localDate, temperature));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }


}
