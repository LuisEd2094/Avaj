package simulator.tower;

import java.util.List;
import java.util.ArrayList;

import simulator.aircraft.Aircraft;
import simulator.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable){
        observers.add(p_flyable);
        if (p_flyable instanceof Aircraft && this instanceof WeatherTower)
        {
            Aircraft air = (Aircraft)p_flyable;
            air.registerTower((WeatherTower)this);
            System.out.printf("Tower says: %s#%s(%d) registered to weather tower.%n", air.getType(), air.getName(), air.getId());
        }

    }
    public void unregister(Flyable p_flyable){
        observers.remove(p_flyable);
        if (p_flyable instanceof Aircraft && this instanceof WeatherTower)
        {
            Aircraft air = (Aircraft)p_flyable;
            System.out.printf("Tower says: %s#%s(%d) unregistered from weather tower.%n", air.getType(), air.getName(), air.getId());
        }
    }
    
    protected void conditionChanged(){
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
