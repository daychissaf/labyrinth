package labyrinth;

public class ArcParser implements ArcsParser {
    @Override
    public Arcs parseStringToArc(String arc) {

        String startNode = String.valueOf(arc.charAt(0));
        String destinationNode = String.valueOf(arc.charAt(2));
        Door door = new Door(String.valueOf(arc.charAt(1)));
        return new Arcs(startNode, destinationNode, door);
    }
}
