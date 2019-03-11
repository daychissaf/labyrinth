package labyrinth.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import labyrinth.exception.DoorAlreadyClosedException;
import labyrinth.interfaces.Tracker;
import labyrinth.models.Path;
import labyrinth.models.Room;

public class SimpleTracker implements Tracker {
    private List<Path> arcs = new ArrayList<>();
    private Room currentRoom;

    @Override
    public void addPath(Path path) {
        arcs.add(path);
        currentRoom = path.getTo();
    }
    private Path getLastPath() {
        return arcs.get(arcs.size() - 1);
    }


    @Override
    public List<Path> monitoredPaths() {
        return arcs.stream().filter(path -> path.getDoorType().isMonitored()).collect(Collectors.toList());
    }

    @Override
    public Room getCurrentRoom() {
        if (currentRoom == null)
            throw new UnsupportedOperationException();
        else
            return currentRoom;
    }
    @Override
    public void popIn(Room room) {
        currentRoom = room;
    }

    @Override
    public void closeLastPath() throws DoorAlreadyClosedException {
        Path lastPath = this.getLastPath();
        if (lastPath.isOpen())
            this.getLastPath().close();
        else throw new DoorAlreadyClosedException();
    }
}
