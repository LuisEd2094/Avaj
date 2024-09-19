package simulator.aircraft;

import java.util.HashMap;
import java.util.Map;
import simulator.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    private static Map<String, Map<String, int[]>> actions = new HashMap<>();
    // int[0] == Latitude
    // int[1] == Longitude
    // int[2] == Height
    static {
        actions.put("JetPlane", createActions(
            new String[]{"SUN", "RAIN", "FOG", "SNOW"},
            new int[][]{
                {10, 0, 2},
                {5, 0, 0},
                {1, 0, 0},
                {0, 0, -7}
            }
        ));
        actions.put("Helicopter", createActions(
            new String[]{"SUN", "RAIN", "FOG", "SNOW"},
            new int[][]{
                {0, 10, 2},
                {0, 5, 0},
                {0, 1 , 0},
                {0, 0, -12}
        }));
        actions.put("Baloon", createActions(
            new String[]{"SUN", "RAIN", "FOG", "SNOW"},
            new int[][]{
                {0, 2, 4},
                {0, 0, -5},
                {0, 0, -3},
                {0, 0, -15}
        }));
    }

    private static Map<String, int[]> createActions(String[] weathers, int[][] changes) {
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < weathers.length; i++) {
            map.put(weathers[i], changes[i]);
        }
        return map;
    }

    public static int[] getAction(String Aircraft, String weather){
        if (actions.containsKey(Aircraft) && actions.get(Aircraft).containsKey(weather))
            return actions.get(Aircraft).get(weather);
        return null;
    }


    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower){
        weatherTower = p_tower;
    };

}
