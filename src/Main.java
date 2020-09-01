import GameLogic.GameBoard;
import MoveLogic.FileManipulator;
import MoveLogic.Node;

import java.util.Scanner;

public class Main {

    public static final Integer depth = 4;

    public static void main(String[] args)
    {
        //System.out.print(game.toString());

        //GameLogic game = new GameLogic();
        //game.playGame();

        //System.out.println("for debug: " + testingNode.findMove());
        //System.out.println("number of positions evaluated: " + testingNode.getNumOfPositions());

        runScript();
        //SpaceWeight space = new SpaceWeight();
        //System.out.println(space.getWeights()[5][6]);

    }

    public static void runOtherScript()
    {
        GameBoard game = new GameBoard();
        game.placePiece(1);//place2
        Node testingNode = new Node(0, game, depth);
        game.placePiece(testingNode.findMove());
        System.out.println("----------------------------------------------------");
        System.out.println(game.toString());
        //game.placePiece(5);//place1
        game.placePiece(2);
        Node testTwo = new Node(0, game, depth);
        game.placePiece(testTwo.findMove());
        System.out.println("----------------------------------------------------");
        System.out.println(game.toString());
        //game.placePiece(5);
        game.placePiece(3);
        Node testThree = new Node(0, game, depth);
        game.placePiece(testThree.findMove());
        System.out.println("----------------------------------------------------");
        System.out.println(game.toString());
        //game.placePiece(6);
        //game.placePiece(2);

        //game.placePiece(3);
        //game.placePiece(3);
        //game.placePiece(1);
    }

    public static void runScript()
    {
        GameBoard game = new GameBoard();
        game.placePiece(3);//place2
        game.placePiece(0);//place1

        game.placePiece(2);
        game.placePiece(6);
        /*
        game.placePiece(2);
        game.placePiece(1);

        game.placePiece(1);
        game.placePiece(6);

        game.placePiece(0);
        game.placePiece(0);
        */
        game.placePiece(0);
        game.placePiece(5);

        game.placePiece(1);
        Node testingNode = new Node(0, game, depth);
        game.placePiece(testingNode.findMove());
        //game.placePiece(3);
        System.out.println(game.toString());
        System.out.println(game.checkWin());
        //game.playGame();
        GameBoard test = new GameBoard();



        game.placePiece(1);
        game.placePiece(new Node(0, game, depth).findMove());
        System.out.println(game.toString());
    }

    public static void runGame()
    {
        GameBoard game = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        while(!game.checkWin())
        {
            int nextrow;
            if(!game.getRedTurn())
            {
                System.out.println("it is " + game.getTurn() + "'s turn. Enter a row(1-7): ");
                nextrow = Integer.parseInt(scanner.nextLine()) - 1;
            }
            else
            {
                System.out.println("it is " + game.getTurn() + "'s turn. Computing move...");
                Node newPosition = new Node(0,game, depth);
                nextrow = newPosition.findMove();
                System.out.println("Placing piece on row " + (nextrow+1) + ".");
            }
            game.placePiece(nextrow);
            System.out.println(game.toString());
        }
        System.out.println("The loser is: " + game.getTurn());
    }

    //TODO: make the read in wait on a change in the game.
    public static void runJSGame()
    {
        GameBoard game = new GameBoard();
        FileManipulator fileMan = new FileManipulator();
        while(!game.checkWin())
        {
            int nextrow;
            if(!game.getRedTurn())
            {
                System.out.println("it is " + game.getTurn() + "'s turn. Enter a row(1-7): ");
                nextrow = fileMan.readNewCoordinates().getX();
            }
            else
            {
                System.out.println("it is " + game.getTurn() + "'s turn. Computing move...");
                Node newPosition = new Node(0,game, depth);
                nextrow = newPosition.findMove();
                System.out.println("Placing piece on row " + (nextrow+1) + ".");
            }
            game.placePiece(nextrow);
            System.out.println(game.toString());
        }
        System.out.println("The loser is: " + game.getTurn());
    }
}



