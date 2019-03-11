package labyrinth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Labyrinth {

   private List<Arcs> path;
   private List<Arcs> sensors;

    private String actualNode;
    private Arcs actualArc;

    private ArcsParser parser=new ArcParser();
    private Printer sensorsprinter=new PrintSensors();

    public Labyrinth(String... arcs) {

        path = new ArrayList<Arcs>();
        sensors=new ArrayList<Arcs>();
        for (String arc : arcs)
            path.add(parser.parseStringToArc(arc));
    }

    public void popIn(String popInNode) {
        if (checkNodeIfExist(popInNode))
            actualNode = popInNode;
        else
            throw new NotFoundPopInNodeException();
    }

    public boolean walkTo(String walkToNode) {

        Optional<Arcs> arcs = path.stream().filter(arc -> isInPath(arc, walkToNode)).findFirst();
        if (arcs.isPresent())
            if (arcs.get().canPasse()) {
                actualArc = arcs.get();
                actualNode = walkToNode;
                addToSensors(arcs.get());
                return true;
            } else throw new ClosedDoorException();
        throw new IllegalMoveException();
    }

    private boolean isInPath(Arcs arc,String walkToNode){
        return arc.isStartNode(actualNode) && arc.isDestinationNode(walkToNode)
            || arc.isDestinationNode(actualNode) && arc.isStartNode(walkToNode);
    }

    private void addToSensors(Arcs arc){
        if (arc.doorType().equals(DoorType.FIRST_TYPE))
            sensors.add(arc);
    }

    public void closeLastDoor() {
        if (!actualArc.closeDoor())
            throw new DoorAlreadyClosedException();

    }

    public String readSensors() {
        return sensorsprinter.printSensors(sensors);
    }


    private boolean checkNodeIfExist(String node) {
        for (Arcs arc : path) {
            if (arc.isStartNode(node)) return true;
        }
        return false;
    }
}
