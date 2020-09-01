package MoveLogic;

import GameLogic.Coordinates;
import GameLogic.GameBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO: figure out whats wrong with this shit, because it's not seeing losses in the immediate future
//TODO: I believe that this isn't properly searching and finding the losses in the future. Not sure
//why it's not doing this, but it defintely isn't.
public class Node implements MoveMaker
{
    static int numOfPositions = 0;
    int level;
    int val;
    GameBoard thisBoard;
    List<Node> subNodes = new ArrayList<>();
    SpaceWeight weighter = new SpaceWeight();
    static FileManipulator fileMan = new FileManipulator();


    public Node(int parentLevel, GameBoard thisBoard, int maxLevel)
    {
        this.level = parentLevel + 1;
        this.thisBoard = thisBoard;

        if(level<maxLevel)
        {
            for(int i=0;i<7;i++)
            {
                if(thisBoard.checkLegalMove(i) || !thisBoard.checkWin())
                {
                    numOfPositions++;
                    GameBoard newBoard = new GameBoard(thisBoard.getBoard(), thisBoard.getyLevel(), thisBoard.getRedTurn());
                    newBoard.placePiece(i);
                    subNodes.add(new Node(level, newBoard, maxLevel));
                }
                //TODO: I do believe that this is the issue. Not sure if it is actually checking
                //to see if a certain move means victory or not.
                if(thisBoard.getWinner()==2)
                {
                    val = -1;
                }
                /*if(thisBoard.checkWin())
                {
                    if(thisBoard.getWinner()==1) {
                        //val = weighter.findWeight(thisBoard.getCoordsForMove(i));
                        //val = 1;
                    }
                    else
                    {
                        //System.out.println("yes");
                        val = -1 ;//* (10 * maxLevel-(parentLevel-1))
                    }
                }*/
                //TODO: this is apparently not the place to sum subnodes?? Idk
                else {
                }
            }
        }
        for(Node n: subNodes)
        {
            val += n.getVal();
        }
    }

    public int getVal()
    {
        return val;
    }

    public int findVal()
    {
        if(thisBoard.checkWin() && thisBoard.getRedTurn()) {
            return 1 + findVal();
        }
        else if(thisBoard.checkWin() && !thisBoard.getRedTurn()) {
            return findVal() - 1;
        }
        else
        {
            int val = 0;
            for(Node n: subNodes)
            {
                val += n.findVal();
            }
            return val;
        }
    }

    //TODO: Found an issue, not sure what's causing it. The value of the highest sub node
    //isn't being calculated. Sometimes it is and sometimes it isn't. Kinda drunk so I don't
    //care to figure it out rn.
    public Integer findMove()
    {
        int highestVal = -2147483647;
        int retVal=0;
        int zeroCount=0;


        for(int i=0;i<7;i++)
        {
            int temp = subNodes.get(i).getVal();
            System.out.println("subnode " + i + "'s value: " + temp);
            if(temp>highestVal && thisBoard.checkLegalMove(i)) {
                highestVal = temp;
                retVal = i;
            }
            else if(temp == 0)
            {
                zeroCount++;
            }
        }
        if(zeroCount==6)
            retVal=3;
        fileMan.writeNewCoordinates(new Coordinates(retVal, 6));
        return retVal;
    }

    public int getNumOfPositions()
    {
        return numOfPositions;
    }
}
