package MoveLogic;

import GameLogic.Coordinates;
import GameLogic.GameBoard;

import java.util.ArrayList;
import java.util.List;

//TODO: ok so this class isn't totally useless, I don't think at least. My implementation is probably what's off.
//TODO: might have to scrap it all and start again. Don't love how this is turning out.
public class SpaceWeight
{
    Integer[][] weights = {{3, 4, 6, 7, 5, 4, 3},
            {4, 6, 8, 10, 8, 6, 4},
            {5, 7, 11, 13, 11, 7, 5},
            {5, 7, 11, 13, 11, 7, 5},
            {4, 6, 8, 10, 8, 6, 4},
            {3, 4, 6, 7, 5, 4, 3}};

    public SpaceWeight()
    {

    }

    public Integer[][] getWeights()
    {
        return weights;
    }

    public Integer findWeight(Coordinates c)
    {
        return weights[c.getY()][c.getX()];
    }

    public List<Coordinates> getNextMoves(GameBoard check)
    {
        List<Coordinates> nextMoves = new ArrayList<>();
        for(int i=0; i<7; i++)
        {
            if(check.checkLegalMove(i))
                nextMoves.add(new Coordinates(i, check.getyLevel()[i]));
        }
        return nextMoves;
    }

    public List<Integer> getTheWeights(GameBoard check)
    {
        List<Integer> retVal = new ArrayList<>();
        for(Coordinates c: getNextMoves(check))
        {
            retVal.add(findWeight(c));
        }
        return retVal;
    }
}
