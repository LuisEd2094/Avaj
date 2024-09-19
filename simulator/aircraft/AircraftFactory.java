package simulator.aircraft;

import java.util.HashMap;
import java.util.Map;

import java.util.function.BiFunction;


public class AircraftFactory {
    private static AircraftFactory  instance = null;
    private static long             id = 1;
    private final Map<String, BiFunction<String, Coordinates, Aircraft>> constructorMap = new HashMap<>();

    private AircraftFactory() {
        // Register constructors with name and coordinates
        constructorMap.put("Helicopter", (name, coords) -> new Helicopter(id++, name, coords));
        constructorMap.put("JetPlane", (name, coords) -> new JetPlane(id++, name, coords));
        constructorMap.put("Baloon", (name, coords) -> new Baloon(id++, name, coords));
    }

    public static AircraftFactory getInstance()
    {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Aircraft newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        BiFunction<String, Coordinates, Aircraft> constructor = constructorMap.get(p_type);
        
        if (constructor != null)
        {
            return constructor.apply(p_name, p_coordinates);
        }
        return null;
    }
}
