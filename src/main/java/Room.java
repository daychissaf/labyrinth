import java.util.*;

public class Room {
    private String roomName;
    private List<Gate> gates=new ArrayList<Gate>();

    public String getRoomName() {
        return roomName;
    }

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public void addGate(Gate newGate) {
        gates.add(newGate);
    }

    public List<Gate> getGates() {
        return gates;
    }
}
