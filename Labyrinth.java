package CleanCode2.Labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
    private final char UNMONITERED_PATH = '|';
    private final char MONITERED_PATH = '$';
    private LabyrinthParser labyrinthParser;
    private List<Move> allMoves;
    private String currentPosition;
    private Move lastMove;
    private List<Move> coveredMoves;

    public Labyrinth(String... possibleMoves) {
        coveredMoves = new ArrayList<Move>();
        initiateParser();
        allMoves = labyrinthParser.getPossibleMoves(possibleMoves);
    }

    public void initiateParser() {
        labyrinthParser = StringParser.getInstance();
    }

    public void popIn(String startPoint) {
        currentPosition = startPoint;
    }

    public void walkTo(String nextPosition) throws IllegalMoveException, ClosedDoorException {

        if (isViableTransition(nextPosition))
        {
            currentPosition = nextPosition;
        }

        else{
            throw new IllegalMoveException();
        }
    }

    public boolean isViableTransition(String endPoint) throws ClosedDoorException {
        Move currentMove = labyrinthParser.getMove(currentPosition + MONITERED_PATH + endPoint);
        int positionOfTheMove = allMoves.indexOf(currentMove);
        if (positionOfTheMove < 0)
            return false;
        Move storedMove = allMoves.get(positionOfTheMove);
        if (storedMove.isOpen()) {
            lastMove = storedMove;
            if (storedMove.have(MONITERED_PATH))
                coveredMoves.add(storedMove);
            return true;
        } else
            throw new ClosedDoorException();
    }

    public void closeLastDoor() throws DoorAlreadyClosedException {
        Move lastMoveInversed = lastMove.inverse();
        if (lastMove.isOpen()) {
            int lastMovePosition = allMoves.indexOf(lastMove);
            int lastMoveInversedPosition = allMoves.indexOf(lastMoveInversed);
            lastMove.changedState();
            lastMoveInversed.changedState();
            allMoves.set(lastMovePosition, lastMove);
            allMoves.set(lastMoveInversedPosition, lastMoveInversed);
        } else
            throw new DoorAlreadyClosedException();
    }

    public String readSensors() {
        StringBuilder sensors = new StringBuilder();

        for (Move move : coveredMoves) {

            sensors.append(
                    isLastCoveredMove(move)
                            ? move
                            : move + ";"
            );

        }
        return sensors.toString();
    }


    public boolean isLastCoveredMove(Move move) {
        return coveredMoves.size() - 1 == coveredMoves.indexOf(move);
    }
}
