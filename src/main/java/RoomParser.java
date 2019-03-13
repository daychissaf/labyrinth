import java.util.ArrayList;
import java.util.List;

public class RoomParser {

    public static final String GATE_WITH_SENSOR_SEPARATOR = "$";
    public static final String GATE_SEPARATOR = "|";

    public static List<RoomPair> createRooms(String... rooms) {
        List<RoomPair> roomList = new ArrayList<RoomPair>();
        String[] rooms_values = {""};
        for (String roomSeparated : rooms) {
            if (roomSeparated.contains(GATE_WITH_SENSOR_SEPARATOR)) {
                rooms_values = roomSeparated.split("\\" +GATE_WITH_SENSOR_SEPARATOR);
                Room room1 = new Room(rooms_values[0]);
                Room room2 = new Room(rooms_values[1]);
                roomList.add(new RoomPair(room1,room2,DoorType.WITH_SENSOR));

            } else {
                rooms_values = roomSeparated.split("\\" +GATE_SEPARATOR);
                Room room1 = new Room(rooms_values[0]);
                Room room2 = new Room(rooms_values[1]);
                roomList.add(new RoomPair(room1,room2,DoorType.WITHOUT_SENSOR));
            }

        }
        return roomList;
    }


}
