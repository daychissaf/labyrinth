package CleanCode2.Labyrinth;

import java.util.Objects;

public class Move {
    private Character startPoint;
    private Character endPoint;
    private boolean open = true;
    private Character typeOFPath;


    public Move(char startPoint, char endPoint, char typeOFPath) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.typeOFPath = String.valueOf(typeOFPath).charAt(0);
    }

    public Move(char startPoint, char endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Move(String startPoint, String endPoint) {
        this.startPoint = startPoint.charAt(0);
        this.endPoint = endPoint.charAt(0);
    }


    public void changedState() {
        open = false;
    }


    public Move inverse() {
        return new Move(endPoint, startPoint);
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public String toString() {
        return startPoint + endPoint.toString();
    }

    public boolean have(char monitered_path) {
        return typeOFPath == monitered_path;
    }

    @Override
    public boolean equals(Object object) {
        Move move = (Move) object;
        return startPoint == move.startPoint &&
                endPoint == move.endPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}
