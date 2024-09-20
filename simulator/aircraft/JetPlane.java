package simulator.aircraft;
import java.util.HashMap;
import java.util.Map;

public class JetPlane extends Aircraft {
    private static Map<String, String> msgs = new HashMap<>();

    static {
        msgs.put("SUN", "I am getting hotter!");
        msgs.put("RAIN", "It's raining man, hallelujah!");
        msgs.put("FOG", "It's foggy outside, there might be a Silent Hill close by");
        msgs.put("SNOW", "Time to make some snow angels");
    }
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "JetPlane";
    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);

        this.coordinates.updateCoordinates(Flyable.getAction("JetPlane", weather));
        this.printMsg(JetPlane.msgs.get(weather));
        if (this.coordinates.getHeight() <= 0)
            this.unregisterTower("Me voy porque no me quieres");
    }
    
}
