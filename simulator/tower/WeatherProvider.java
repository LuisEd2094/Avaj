package simulator.tower;

import simulator.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getInstance()
    {
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }
    public String getCurrentWeather(Coordinates p_coordinates)
    {
        int pos = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
        return weather[pos % 4];
    }
    
}
