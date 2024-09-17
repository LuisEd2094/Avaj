package simulator.tower;

import java.util.List;

import simulator.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable p_flyable){
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable){
        observers.remove(p_flyable);
    }
    protected void conditionChanged(){

    }
}
