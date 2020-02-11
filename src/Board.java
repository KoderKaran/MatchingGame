import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int difficulty;
    private int[][] board;
    private Random rnd;

    private int test;
    public Board(int x, int y, int newDifficulty){
        rnd = new Random();
        difficulty = newDifficulty+1;
        board = new int[y][x];
        initBoard();
        printBoard();
    }

    public void initBoard(){
        for(int[] array:board){
            for(int i = 0; i<array.length; i++){
                array[i] = rnd.nextInt(difficulty);
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<board.length; i++){
            System.out.print("   " + i );
        }
        System.out.println(" ");
        int arrayCounter = 0;
        for(int[] array:board){
            System.out.print(arrayCounter + " ");
            arrayCounter++;
            for(int i:array){
                System.out.print("[" + i + "] ");
            }
            System.out.println(" ");
        }
    }

    public ArrayList<Match> getVerticalMatches(){
        ArrayList<Match> matches = new ArrayList<>();
        for(int i = 0; i<board.length; i++){
            int[] array = board[i];
            for(int j = 0; j<array.length; j++){
                if(array[j] == board[i+1][j] && array[j] == board[i+2][j]){
                    matches.add(new Match(new Pair(i, j), new Pair(i+2, j)));
                }
            }
            if((board.length - (i+1)) < 3){
                break;
            }
        }
        return matches;
    }

    public ArrayList<Match> getHorizontalMatches(){
        ArrayList<Match> matches = new ArrayList<>();
        for(int k = 0; k<board.length; k++){
            int[] array = board[k];
            for(int i = 0; i<array.length; i++) {
                int first = array[i];
                if (first == array[i + 1] && first == array[i + 2]) {
                    matches.add(new Match(new Pair(k, i), new Pair(k, i + 2)));
                }
                if((array.length - (i+1)) < 3){
                    break;
                }
            }
        }
        return matches;
    }

    public ArrayList<Match> getMatches(){
        ArrayList<Match> matches = new ArrayList<>();
        ArrayList<Match> horizontal = this.getHorizontalMatches();
        ArrayList<Match> vertical = this.getVerticalMatches();
        matches.addAll(horizontal);
        matches.addAll(vertical);
        return matches;
    }
}

