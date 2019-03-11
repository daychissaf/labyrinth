package Classes;

import Classes.Arc;
import Interfaces.Printer;

import java.util.ArrayList;
import java.util.List;

public class SensorsPrinter implements Printer {

    private static final String SEMICOLON =";";

    @Override
    public String printSensors(List<Arc> path) {
        List<String> sensors=new ArrayList<String>();
        for (Arc arc : path)
            sensors.add(arc.startAndDestinationRooms());

        return String.join(SEMICOLON,sensors);
    }
}
