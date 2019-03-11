package Classes;

import Exceptions.ClosedDoorException;
import Exceptions.DoorAlreadyClosedException;
import Exceptions.IllegalMoveException;
import Interfaces.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Labyrinth {
    private String currentRoom;
    private Arc currentArc;
    private List<Arc> path;
    private List<Arc> sensors;
    private ArcParser parser=new ArcParser();
    private Printer sensorsprinter=new SensorsPrinter();

    public Labyrinth(String... arcs) {

        path = new ArrayList<Arc>();
        sensors=new ArrayList<Arc>();
        for (String arc : arcs)
            path.add(parser.parseStringToArc(arc));
    }

    public void popIn(String popInRoom) {
            currentRoom = popInRoom;
    }

    public boolean walkTo(String walkToRoom) {

        Optional<Arc> arcs = path.stream().filter(arc -> isInPath(arc, walkToRoom)).findFirst();
        if (arcs.isPresent())
            if (arcs.get().canGoThroughTheDoor()) {
                currentArc = arcs.get();
                currentRoom = walkToRoom;
                addToSensors(arcs.get());
                return true;
            } else throw new ClosedDoorException();
        throw new IllegalMoveException();
    }

    private boolean isInPath(Arc arc,String walkToRoom){
        return arc.isStartRoom(currentRoom) && arc.isDestinationRoom(walkToRoom)
            || arc.isDestinationRoom(currentRoom) && arc.isStartRoom(walkToRoom);
    }

    private void addToSensors(Arc arc){
        if (arc.doorType().equals(Door.DoorType.FIRST_TYPE))
            sensors.add(arc);
    }

    public void closeLastDoor() {
        if (!currentArc.closeTheDoor())
            throw new DoorAlreadyClosedException();

    }

    public String readSensors() {
        return sensorsprinter.printSensors(sensors);
    }


    private boolean isRoomExist(String room) {
        for (Arc arc : path) {
            if (arc.isStartRoom(room)) return true;
        }
        return false;
    }
}
