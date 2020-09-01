package GameLogic;

import java.util.Scanner;

public class GameLogic
{
    GameBoard gameBoard = new GameBoard();
    Scanner scanner = new Scanner(System.in);
    Integer[][] tempBoard;


    public GameLogic()
    {
        tempBoard = gameBoard.getBoard();
    }

    public void playGame()
    {
        int nextrow;
        while(!checkWin())
        {
            System.out.println("it is " + gameBoard.getTurn() + "'s turn. Enter a row: ");
            nextrow = Integer.parseInt(scanner.nextLine());
            gameBoard.placePiece(nextrow);
            tempBoard = gameBoard.getBoard();
            System.out.println(toString());
        }
    }

    public boolean checkLegalMove(int row)
    {
        return gameBoard.checkLegalMove(row);
    }

    public void placePiece(int row)
    {
        gameBoard.placePiece(row);
        tempBoard = gameBoard.getBoard();
    }

    public boolean checkWin()
    {
        return checkDiagonalWin() || checkHorizontalWin() || checkVerticalWin();
    }

    public boolean checkHorizontalWin()
    {
        Integer[] counts = new Integer[3];
        for(int i=0;i<3;i++)
            counts[i]=0;
        int prevVal=0;
        int currStreak=0;
        for(int j=0;j<6;j++)
        {
            for(int i=0;i<7;i++)
            {
                if((tempBoard[i][j]== prevVal) && (prevVal==1 || prevVal==2))
                {
                    counts[prevVal]++;
                    if(counts[prevVal]==3)
                        return true;
                    currStreak = prevVal;
                }
                else
                {
                    counts[currStreak] = 0;
                }
                prevVal = tempBoard[i][j];
            }
        }
        return false;
    }

    public boolean checkVerticalWin()
    {
        Integer[] counts = new Integer[3];
        for(int i=0;i<3;i++)
            counts[i]=0;
        int prevVal=0;
        int currStreak=0;
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
            {
                if((tempBoard[i][j]== prevVal) && (prevVal==1 || prevVal==2))
                {
                    counts[prevVal]++;
                    if(counts[prevVal]==3)
                        return true;
                    currStreak = prevVal;
                }
                else
                {
                    counts[currStreak] = 0;
                }
                prevVal = tempBoard[i][j];
            }
        }
        return false;
    }

    public boolean checkDiagonalWin()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return gameBoard.toString();
    }
}

/*
for(int i=0;i<7;i++)
{
    for(int j=0;j<6;j++)
    {

    }
}
 */
