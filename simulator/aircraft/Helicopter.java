package simulator.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";
    }

    @Override
    public void updateConditions(){
        this.coordinates.updateCoordinates(Flyable.getAction("Baloon", weatherTower.getWeather(coordinates)));
        this.unregisterTower("Me voy porque no me quieres");
    }
    
}
