import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Game {
    Player[] players;
    Board board;
    boolean gameOver;
    int turn;
    int noOfMoves;
    String zeros,cross;
    Game(Player[] players, Board board){
        this.players = players;
        this.board = board;
        gameOver = false;
        turn = 0;
        noOfMoves = 0;
        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();
        for(int i=0;i<board.size;i++)
        {
            z.append("0");
            c.append("x");
        }
        zeros = z.toString();
        cross = c.toString();
    }
    public void play(){
        while(!gameOver){
            printBoard();
            noOfMoves++;
            //System.out.println("movesNo-"+noOfMoves);
            if(noOfMoves >= 2*board.size-1 && checkIfEnded()){
                System.out.println(players[turn^1].getName()+" has won the game!!!");
                gameOver = true;
                return;
            }
            if(noOfMoves > (board.size)*(board.size))
            {
                System.out.println("Match drawn");
                gameOver = true;
                return;
            }
            int idx = getIndex();
            int row = idx / board.size;
            int col = idx % board.size;
            board.board[row][col] = players[turn].getSymbol();

            turn^=1;
        }
    }

    public int getIndex(){
        while(true){
        System.out.println("Enter the position no in the range of 1 - "+(board.size)*(board.size));
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt()-1;
        if(pos < 0 || pos > (board.size)*(board.size)){
            System.out.println("Please Enter Valid position");
            continue;
        }
        else{
            int rowIndex = pos / board.size;
            int colIndex = pos % board.size;
            if(board.board[rowIndex][colIndex] == '-'){
                return pos;
            }
            else{
                System.out.println("Position is already filled");
                continue;
            }

        }
      }
    }

    public boolean checkIfEnded(){
        //Row wise traversal
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.size;i++){
             sb = new StringBuilder();
            for(int j=0;j<board.size;j++){
                sb.append(board.board[i][j]);
            }
            String str = sb.toString();
            // System.out.println("pr-1"+str);
            if(str.equals(zeros) || str.equals(cross)){
                return true;
            }
        }
        //Column wise traversal
        for(int i=0;i<board.size;i++){
             sb = new StringBuilder();
            for(int j=0;j<board.size;j++){
                sb.append(board.board[j][i]);
            }
            String str = sb.toString();
            // System.out.println("pr-2"+str);
            if(str.equals(zeros) || str.equals(cross)){
                return true;
            }
        }
        //Major diagonal traversal
        sb = new StringBuilder();
        for(int i=0;i<board.size;i++){
            for(int j=0;j<board.size;j++){
                if(i == j){
                    sb.append(board.board[i][j]);
                }
            }
        }
        String str = sb.toString();
        // System.out.println("pr-3"+str);
        if(str.equals(zeros) || str.equals(cross)){
            return true;
        }

     // Minor diagonal traversal
     sb = new StringBuilder();
     for(int i=0;i<board.size;i++){
        for(int j=0;j<board.size;j++){
            if((i+j) == board.size-1){
                sb.append(board.board[i][j]);
            }
        }
    }
     str = sb.toString();
    //  System.out.println("pr-4"+str);
    if(str.equals(zeros) || str.equals(cross)){
        return true;
    }

    return false;
    }

    public void printBoard(){
        for(char[] oneD : board.board){
            for(char ch : oneD){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

}
