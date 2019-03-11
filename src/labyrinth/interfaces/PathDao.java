package labyrinth.interfaces;


import labyrinth.exception.IllegalMoveException;
import labyrinth.models.Path;
import labyrinth.models.Room;

public interface PathDao {
    void save(Path path);
    boolean containsRoom(Room room);
    Path searchForPath(Room from, Room to) throws IllegalMoveException;
}
