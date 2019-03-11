package CleanCode2.Labyrinth;

import java.util.ArrayList;
import java.util.List;

public class StringParser implements LabyrinthParser {
    private static StringParser labyrinthParser;
    private StringParser(){
        super();
    }
    public static StringParser getInstance(){
        if(labyrinthParser==null) {
            labyrinthParser = new StringParser();
            return labyrinthParser;
        }
        else
            return labyrinthParser;

    }
    @Override
    public List<Move> getPossibleMoves(String... possibleMoves) {
        List<Move> allMoves=new ArrayList<Move>();
        for(String move:possibleMoves){
            allMoves.add(new Move(move.charAt(0),move.charAt(2),move.charAt(1)));
            allMoves.add(new Move(move.charAt(2),move.charAt(0),move.charAt(1)));
        }
        return allMoves;
    }

    @Override
    public Move getMove(String move) {
        return new Move(move.charAt(0),move.charAt(2),move.charAt(1));
    }


}
