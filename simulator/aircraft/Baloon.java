package simulator.aircraft;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";

    }

    @Override
    public void updateConditions(){
        this.coordinates.updateCoordinates(Flyable.getAction("Baloon", weatherTower.getWeather(coordinates)));
        this.unregisterTower("Me voy porque no me quieres");

    }
    
}
