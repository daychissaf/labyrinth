import java.util.List;

public class Gate {
    public Room originRoom;
    public Room destinationRoom;
    public String typeGate;
    public boolean open=true;
    //or using GateType enum
    private static final String TYPE_GATE_SENSOR="$";
    private static final String TYPE_GATE_NORMAL="|";

    public void closeDoor(){
    	this.open=false;
    }

	public boolean isOpen() {
		return open;
	}


    public Gate(Room originRoom, Room destinationRoom, String typeGate) {
		this.originRoom = originRoom;
		this.destinationRoom = destinationRoom;
		this.typeGate = typeGate;
	}

	public Room getOriginRoom() {
        return originRoom;
    }


    public Room getDestinationRoom() {
        return destinationRoom;
    }

    public boolean isSensor(){
        return (typeGate.equals(TYPE_GATE_SENSOR))?true:false;
    }
}
