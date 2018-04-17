import java.util.Scanner;

public class MancalaDriver {
    private static final int rows = 2; //should always be 2
    private static final int columns = 12; //columns must always be greater >= 2
    private static final int startingSeeds = 3; //The amount of seeds to place in each hole to initialize the board

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Board board = new Board(rows, columns, 1, startingSeeds);
        board.initializeBoard();

        int currPlayer = 1; //1 for player, 0 for cpu

        Board board2 = new Board(rows, columns, 1, startingSeeds);
        board2.initializeBoard();
        Node<Board> n1 = new Node(board2);
        Tree tree = new Tree(n1);
        //n1 = tree.genTree(n1, currPlayer);
        //tree.minmax(board, n1, currPlayer, 15);

        boolean go = true;
        while (go) {
            board.displayBoardState();

            System.out.print("\n\tPlease enter a move to make (1 to 10)");
            String choice = in.next();
            try {
                currPlayer = 1;
                int choiceInt = Integer.parseInt(choice);
                board.makeMove(currPlayer, choiceInt);
                board.displayBoardState();
                currPlayer = 0;
                tree.minmax(board, currPlayer, 4);
                if (board.checkIfWon() >= 0 && board.checkIfWon() < 2){
                    System.out.println("Winner! Player: " + board.checkIfWon());
                }
                else if (board.checkIfWon() == 2){
                    System.out.println("TIE :/ ");
                }
                //System.out.println("Current h value: " + board.getHValue());



            } catch(NumberFormatException e){
                System.out.println("Exiting...");
                go = false;
            }
        }


    }



}
