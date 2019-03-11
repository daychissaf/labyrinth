package labyrinth.interfaces;

import java.util.List;

import labyrinth.exception.DoorAlreadyClosedException;
import labyrinth.models.Path;
import labyrinth.models.Room;

public interface Tracker {
    void addPath(Path path);
    List<Path> monitoredPaths();
    Room getCurrentRoom();
    void popIn(Room room);

    void closeLastPath() throws DoorAlreadyClosedException;
}
