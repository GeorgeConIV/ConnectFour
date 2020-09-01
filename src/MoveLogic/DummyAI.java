package MoveLogic;

import GameLogic.Coordinates;
import GameLogic.GameBoard;

public class DummyAI implements MoveMaker
{
    GameBoard thisBoard;

    public DummyAI(GameBoard thisBoard)
    {
        this.thisBoard = thisBoard;
    }

    public AlmostWin checkAlmostWin()
    {
        return new AlmostWin(false, new Coordinates(0,0));
    }

    public AlmostWin checkHorizontalAlmost()
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
                if((thisBoard.getBoard()[i][j]== prevVal) && (prevVal==1 || prevVal==2))
                {
                    counts[prevVal]++;
                    if(counts[prevVal]==2)
                        return new AlmostWin(true, new Coordinates(i, j));
                    currStreak = prevVal;
                }
                else
                {
                    counts[currStreak] = 0;
                }
                prevVal = thisBoard.getBoard()[i][j];
            }
        }
        return new AlmostWin(false, new Coordinates(0,0));
    }

    public Integer findMove()
    {
        return 1;
    }


}
