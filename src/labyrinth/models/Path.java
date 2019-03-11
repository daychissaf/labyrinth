package labyrinth.models;

public class Path  {
    private final Room from;
    private final DoorType door;
    private final Room to;

    public Path(Room from, DoorType door, Room to) {
        this.from = from;
        this.door = door;
        this.to = to;
    }

    public Path reverse() {
        return new Path(to, door, from);
    }

    public Room getFrom() {
        return from;
    }

    public Room getTo() {
        return to;
    }

    public boolean containRoom(Room room) {
        return (from.equals(room) || to.equals(room));
    }

    public boolean isOpen() {
        return door.isOpen();
    }

    public void close() {
        door.close();
    }

    @Override
    public String toString() {
        return from.toString() + to.toString();
    }

    public DoorType getDoorType() {
        return door;
    }
}
