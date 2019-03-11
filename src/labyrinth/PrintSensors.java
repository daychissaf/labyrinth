package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class PrintSensors implements Printer{
    @Override
    public String printSensors(List<Arcs> path) {
        List<String> sensors=new ArrayList<String>();
        for (Arcs arc : path)
            sensors.add(arc.getStartNodeAndDestinationNode());

        return String.join(";",sensors);
    }
}
