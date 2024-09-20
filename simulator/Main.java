package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import simulator.aircraft.Aircraft;
import simulator.aircraft.AircraftFactory;
import simulator.aircraft.Coordinates;
import simulator.tower.WeatherTower;

public class Main{
    public static void main(String[] argv)
    {
        if (argv.length != 1)
        {
            System.out.printf("Incorrect usage, provide a file with simulation details%n");
            System.exit(1);
        }
        try {
            WeatherTower tower = new WeatherTower();

            File file = new File(argv[0]);
            BufferedReader br = new BufferedReader(new FileReader(file));
            int simulationCycles = Integer.parseInt(br.readLine());
            Pattern pattern = Pattern.compile("^[A-Za-z]+ [A-Za-z]\\d+ \\d+ \\d+ \\d+$");
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid format on line " + lineNumber + ": " + line);
                }
                String[] parts = line.split(" ");
                Aircraft air = AircraftFactory.getInstance().newAircraft(parts[0], parts[1], Coordinates.create(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),Integer.parseInt(parts[4])));
                tower.register(air);
                lineNumber++;
            }
            br.close();
            while (simulationCycles-- > 0 && tower.hasObservers())
            {
                tower.changeWeather();
            }

        } catch (IOException e) {
            System.out.printf("Wrong number%n");
            System.exit(1);
        }


    }
}