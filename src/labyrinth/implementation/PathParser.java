package labyrinth.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import labyrinth.interfaces.Parser;
import labyrinth.models.DoorType;
import labyrinth.models.Path;
import labyrinth.models.Room;

public class PathParser implements Parser {
    @Override
    public Path parse(String pathDescription) {
        return createPath(pathDescription);
    }

    private Path createPath(String pathDescription) {
        DoorType door = createDoor(pathDescription);
        List<String> rooms = Arrays.asList(pathDescription.split(Pattern.quote(pathDescription.charAt(1)+"")));
        return new Path(new Room(rooms.get(0)), door, new Room(rooms.get(1)));
    }

    private DoorType createDoor(String pathDescription) {
        return new DoorType(pathDescription.charAt(1));
    }


}
