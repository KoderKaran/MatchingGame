import java.util.ArrayList;

public class PlayGame {
    public static void main(String[] args){
        Board board = new Board(6,6,3);
        ArrayList<Match> matches = board.getMatches();
        for(Match m:matches){
            System.out.println(m.getFirst().getX() + "," + m.getFirst().getY());
            System.out.println(m.getSecond().getX() + "," + m.getSecond().getY());
        }
    }
}
