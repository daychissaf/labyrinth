package labyrinth.implementation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import labyrinth.exception.IllegalMoveException;
import labyrinth.interfaces.PathDao;
import labyrinth.models.Path;
import labyrinth.models.Room;

public class PathDaoImpl implements PathDao {
    private Set<Path> paths = new HashSet<>();

    @Override
    public void save(Path path) {
        paths.add(path);
    }

    @Override
    public boolean containsRoom(Room room) {
        return paths.stream().anyMatch(path -> path.containRoom(room));
    }

    @Override
    public Path searchForPath(Room from, Room to) throws IllegalMoveException {
        Optional<Path> result = paths.stream().filter(path -> path.containRoom(from) && path.containRoom(to)).findFirst();
        if (result.isPresent()) {
            return adjustDirectionOfPath(result.get(), from);
        } else throw new IllegalMoveException();
    }

    private Path adjustDirectionOfPath(Path path, Room from) {
        if (path.getFrom().equals(from)) return path;
        else return path.reverse();
    }
}
