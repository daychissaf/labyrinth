package labyrinth;

import labyrinth.exception.ClosedDoorException;
import labyrinth.exception.DoorAlreadyClosedException;
import labyrinth.exception.IllegalMoveException;
import labyrinth.implementation.PathDaoImpl;
import labyrinth.implementation.PathParser;
import labyrinth.implementation.SimpleTracker;
import labyrinth.implementation.StringTrackerPrinter;
import labyrinth.interfaces.Parser;
import labyrinth.interfaces.PathDao;
import labyrinth.interfaces.Tracker;
import labyrinth.interfaces.TrackerPrinter;
import labyrinth.models.Path;
import labyrinth.models.Room;

public class Labyrinth {
    private Parser parser = new PathParser();
    private PathDao database = new PathDaoImpl();
    private Tracker tracker = new SimpleTracker();
    private TrackerPrinter trackerPrinter = new StringTrackerPrinter();

    public Labyrinth(String... pathsDiscription) {
        for (String pathDiscription : pathsDiscription) {
            Path path = parser.parse(pathDiscription);
            database.save(path);
        }
    }


    public void popIn(String roomDiscription) {
        Room firstRoom = new Room(roomDiscription);
        if (!database.containsRoom(firstRoom))
            throw new UnsupportedOperationException();
        else
            tracker.popIn(firstRoom);
    }

    public void walkTo(String roomDiscription) throws IllegalMoveException, ClosedDoorException {
        Room nextRoom = new Room(roomDiscription);
        if (!database.containsRoom(nextRoom)) throw new IllegalMoveException();
        else {
            Path currentPath = database.searchForPath(tracker.getCurrentRoom(), nextRoom);
            if (currentPath.isOpen())
                tracker.addPath(currentPath);
            else throw new ClosedDoorException();
        }

    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        tracker.closeLastPath();
    }

    public String readSensors() {
        return trackerPrinter.printMonitoredPaths(tracker);
    }


}
