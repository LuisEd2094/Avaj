package simulator;

import simulator.aircraft.AircraftFactory;
import simulator.aircraft.Coordinates;
import simulator.aircraft.Helicopter;
import simulator.tower.WeatherTower;

public class Main{
    public static void main(String[] argv)
    {
        WeatherTower tower = new WeatherTower();
        Helicopter helicopter = (Helicopter) AircraftFactory.getInstance().newAircraft("Helicopter", "Pedro", Coordinates.create(10, 10,10));
        Helicopter helicopter2 = (Helicopter) AircraftFactory.getInstance().newAircraft("Helicopter", "Juan", Coordinates.create(10, 10,10));

        tower.register(helicopter);
        tower.register(helicopter2);

        helicopter2.updateConditions();
    }
}