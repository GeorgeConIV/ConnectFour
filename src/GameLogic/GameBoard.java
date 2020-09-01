package GameLogic;

import java.util.ArrayList;
import java.util.List;

public class GameBoard
{
    //0=nothing, 1=red, 2=yellow;
    Integer[][] gameBoard = new Integer[7][6];
    Integer[] yLevel = new Integer[7];
    Boolean redTurn = false;
    Integer winner = 0;

    public GameBoard()
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
                gameBoard[i][j] = 0;
            yLevel[i] = 0;
        }
    }

    public GameBoard(Integer[][] gameBoard, Integer[] yLevel, boolean redTurn)
    {
        this.gameBoard = gameBoard;
        this.yLevel = yLevel;
        this.redTurn = redTurn;
    }

    public Integer[][] placePiece(int row)
    {
        if(yLevel[row]!=6)
        {
            if(redTurn) {
                gameBoard[row][yLevel[row]] = 1;
                yLevel[row]++;
            }
            else
            {
                gameBoard[row][yLevel[row]] = 2;
                yLevel[row]++;
            }
            checkWin();
            redTurn = !redTurn;

        }

        return gameBoard;
    }

    public Integer[][] getBoard()
    {
        Integer[][] idiot = new Integer[7][6];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
            {
                idiot[i][j] = gameBoard[i][j];
            }
        }
        return idiot;
    }

    public Integer[] getyLevel()
    {
        Integer[] dumbass = new Integer[7];
        for(int i=0;i<7;i++)
        {
            dumbass[i] = yLevel[i];
        }
        return dumbass;
    }

    public Coordinates getCoordsForMove(Integer move)
    {
        return new Coordinates(move, yLevel[move]);
    }

    public boolean getRedTurn(){return redTurn;}

    public boolean checkLegalMove(int row)
    {
        return yLevel[row]!=6;
    }

    public String getTurn()
    {
        if(redTurn)
            return "red";
        else
            return "yellow";
    }

    public boolean checkWin()
    {
        boolean temp = checkDiagonalWin() || checkHorizontalWin() || checkVerticalWin();
        if(temp && redTurn)
        {
            winner = 1;
        }
        if(temp && !redTurn)
        {
            winner = 2;
        }

        return temp;
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
                if((gameBoard[i][j]== prevVal) && (prevVal==1 || prevVal==2))
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
                prevVal = gameBoard[i][j];
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
                if((gameBoard[i][j]== prevVal) && (prevVal==1 || prevVal==2))
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
                prevVal = gameBoard[i][j];
            }
        }
        return false;
    }

    public boolean checkDiagonalWin()
    {
        List<Coordinates> checkCoords = new ArrayList<>();
        //TODO: actually write this lmao
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(gameBoard[i][j]!=0)
                {
                    checkCoords.add(new Coordinates(i, j, gameBoard[i][j]));
                }
            }
        }

        for(Coordinates c:checkCoords)
        {
            if(c.getX()<4){
                if(gameBoard[c.getX()+1][c.getY()+1]==c.getVal() &&
                        gameBoard[c.getX()+2][c.getY()+2]==c.getVal() &&
                        gameBoard[c.getX()+3][c.getY()+3]==c.getVal())
                {
                    return true;
                }
            }
            if(c.getX()>2){
                if(gameBoard[c.getX()-1][c.getY()+1]==c.getVal() &&
                        gameBoard[c.getX()-2][c.getY()+2]==c.getVal() &&
                        gameBoard[c.getX()-3][c.getY()+3]==c.getVal())
                {
                    return true;
                }
            }
        }


        return false;
    }

    public Integer getWinner()
    {
        return winner;
    }

    @Override
    public String toString()
    {
        String retVal = "";
        for(int i=5;i>-1;i--)
        {
            retVal = retVal.concat(" - - - - - - - \n");
            for(int j=0;j<7;j++)
            {
                retVal = retVal.concat("|" );
                retVal = retVal.concat(gameBoard[j][i].toString());
            }
            retVal = retVal.concat("|" + (i+1) + "\n");
        }
        retVal = retVal.concat(" - - - - - - - \n");
        retVal = retVal.concat(" 1 2 3 4 5 6 7 \n");
        return retVal;

    }
}
