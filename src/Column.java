import java.util.ArrayList;
import java.util.List;

public class Column
{
    public static enum SpaceVals
    {
        EMPTY, X, O
    }

    List<SpaceVals> spaces = new ArrayList<>();

    public Column(){}

    //Possibly change this to a bool return value based on whether or not it can place the piece there
    public Boolean placePiece(SpaceVals spaceReq)
    {
        if(spaces.size() < 7)
        {
            spaces.add(spaceReq);
            return true;
        }
        else
        {
            System.out.println("its full dumbass");
            return false;
        }
    }

    public List<SpaceVals> getSpaces()
    {
        return spaces;
    }
}
