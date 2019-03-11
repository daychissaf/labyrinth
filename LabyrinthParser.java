package CleanCode2.Labyrinth;

import java.util.List;

public interface LabyrinthParser {

     List<Move> getPossibleMoves(String ... possibleMoves);
     Move getMove(String move);
}
