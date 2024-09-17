package simulator.tower;

import simulator.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather;

    private WeatherProvider(){}

    public static WeatherProvider getInstance()
    {
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }
    public String getCurrentWeather(Coordinates p_coordinates)
    {
        return "nothing";
    }
    
}
