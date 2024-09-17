package simulator.aircraft;

public class AircraftFactory {
    private static AircraftFactory instance = null;

    private AircraftFactory()
    {
    }

    public static AircraftFactory getInstance()
    {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Flyable  newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        return null;
    }
}
