package labyrinth;

public class Arcs {

    private String startNode;
    private String destinationNode;
    private Door door;

    public Arcs(String startNode, String destinationNode, Door door) {
        this.startNode = startNode;
        this.destinationNode = destinationNode;
        this.door = door;
    }

    public boolean isStartNode(String node){
        return startNode.equals(node);
    }

    public boolean isDestinationNode(String node){
        return destinationNode.equals(node);
    }

    public boolean closeDoor(){
        return door.close();
    }

    public boolean canPasse(){
        return door.doorStat();
    }

    public String getStartNodeAndDestinationNode(){
        return startNode+""+destinationNode;
    }

    public DoorType doorType(){
        return door.isFirstOrSecondDoorType();
    }

    @Override
    public String toString() {
        return startNode+" - "+door+" -> "+destinationNode;
    }
}
