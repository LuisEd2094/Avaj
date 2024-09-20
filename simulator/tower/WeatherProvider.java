package simulator.tower;

import simulator.aircraft.Coordinates;
import java.util.SplittableRandom;
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
        long pos = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude() + (int)(System.currentTimeMillis() / 1000);
        SplittableRandom seed = new SplittableRandom((long)pos);
        int nextInt = seed.nextInt(0, Integer.MAX_VALUE);
        return weather[nextInt % 4];
    }
    
}
