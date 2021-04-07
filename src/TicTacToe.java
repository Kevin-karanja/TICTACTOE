import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> CPUPositions = new ArrayList<>();
    public static void main(String[] args){

        char[] [] gameBoard= {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice(1-9):");
            int position =  scanner.nextInt();
            //System.out.println(position);
            while(playerPositions.contains(position) || CPUPositions.contains(playerPositions)){
                System.out.println("Position already occupied");
                System.out.println("Enter a correct position");
                position = scanner.nextInt();
            }

            placePiece(gameBoard, position,"player");
            String result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
            Random rand = new Random();
            int CPUposition = rand.nextInt(9) +1;
            while(playerPositions.contains(CPUposition) || CPUPositions.contains(CPUposition)){
                System.out.println("Position already occupied");
                System.out.println("Enter a correct position");
                CPUposition = scanner.nextInt(9)+1;
            }
            placePiece(gameBoard, CPUposition,"CPU");
            printGameBoard(gameBoard);
             result = checkWinner();
            System.out.println(result);
        }


}
public static void printGameBoard(char[][] gameBoard){
    for(char[] row : gameBoard){
        for (char c : row) {
            System.out.print(c);
        }
        System.out.println();
    }
}
public static void placePiece(char[][] gameBoard, int position, String user){
        char symbol = ' ';
        if(user.equals("player")) {

            symbol = 'X';
            playerPositions.add(position);
        }
        else if(user.equals("CPU")){
            symbol = 'O';
            CPUPositions.add(position);
        }


    switch (position){
        case 1:
            gameBoard[0][0] = symbol;
            break;
        case 2:
            gameBoard[0][2] = symbol;
            break;
        case 3:
            gameBoard[0][4] = symbol;
            break;
        case 4:
            gameBoard[2][0] = symbol;
            break;
        case 5:
            gameBoard[2][2] = symbol;
            break;
        case 6:
            gameBoard[2][4] = symbol;
            break;
        case 7:
            gameBoard[4][0] = symbol;
            break;
        case 8:
            gameBoard[4][2] = symbol;
            break;
        case 9:
            gameBoard[4][4] = symbol;
            break;
        default:
            break;
    }
}
public static String checkWinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List RightCol = Arrays.asList(3, 6, 9);
        List middleCol = Arrays.asList(2, 5, 8);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);
 List<List> winning = new ArrayList<List>();
    winning.add(topRow);
    winning.add(midRow);
    winning.add(botRow );
    winning.add(leftCol);
    winning.add(RightCol);
    winning.add(middleCol);
    winning.add(cross1);
    winning.add(cross2);

    for (List l :winning){
        if(playerPositions.containsAll(l)){
            return "Congratulations! You beat me!";

        }else if (CPUPositions.containsAll(l)){
            return "You lost. Sorry!";}
            else if (playerPositions.size() + CPUPositions.size() == 9) {
            return "DRAW";}
            }
    return "";
        }
    }



