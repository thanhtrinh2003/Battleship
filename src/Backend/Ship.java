package Backend;

public class Ship
{
    //constants 
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    //instance variables
    private int row = UNSET;
    private int col = UNSET;
    private int length;
    private int direction = UNSET;
    
    public Ship(int length)
    {
        this.length = length;
    }
    
    public boolean isLocationSet()
    {
        if(row ==UNSET && col == UNSET)
        {
            return false;
        }
        return true;
    }
    
    public boolean isDirectionSet()
    {
        if(direction == UNSET)
        {
            return false;
        }
        return true;
    }
    
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    private String directionToString()
    {
        if(direction == HORIZONTAL)
        {
            return "horizontal";
        }
        else if(direction == VERTICAL)
        {
            return "vertical";
        }
        else
        {
            return "unset direction";
        }
    }
    
    private String locationToString()
    {
        if (this.isLocationSet())
            return "(" + row +", " +col+")";
        else
            return "(unset location)";
    }
    
    public String toString()
    {
        return this.directionToString() + " ship of length " + this.getLength() + " at " + this.locationToString();
    }
}
