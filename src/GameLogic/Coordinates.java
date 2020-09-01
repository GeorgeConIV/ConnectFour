package GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Coordinates
{
    Integer x;
    Integer y;
    Integer val;

    public Coordinates(Integer x, Integer y, Integer val)
    {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public Coordinates(Integer x, Integer y)
    {
        this.x = x;
        this.y = y;
    }

    public Integer getX()
    {
        return x;
    }

    public List<String> getWriteable()
    {
        List<String> retVal = new ArrayList<>();
        retVal.add(x.toString());
        retVal.add(y.toString());

        return retVal;
    }

    public Integer getY()
    {
        return y;
    }

    public Integer getVal()
    {
        return val;
    }
}
