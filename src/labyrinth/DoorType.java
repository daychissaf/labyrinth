package labyrinth;

public enum DoorType {

    FIRST_TYPE("$"), SECOND_TYPE("|");

    String symbol;
    boolean stat;

    DoorType(String symbol) {
        this.symbol = symbol;
    }



    @Override
    public String toString() {
        return symbol;
    }
}
