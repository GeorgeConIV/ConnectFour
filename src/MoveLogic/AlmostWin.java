package MoveLogic;

import GameLogic.Coordinates;

public class AlmostWin
{
    boolean hasThree;
    Coordinates coordinates;

    public AlmostWin(boolean hasThree, Coordinates coordinates)
    {
        this.hasThree = hasThree;
        this.coordinates = coordinates;
    }

    public boolean getHasThree()
    {
        return hasThree;
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }
}
