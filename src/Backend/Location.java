package Backend;

public class Location
{
    //instance variable
    private int status;
    private boolean hasShip;
    
    //Implement the Location class here
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    
    public Location()
    {
        this.status = 0;
    }
    
    public boolean checkHit()
    {
        return status == HIT;
    }
    
    public boolean checkMiss()
    {
        return status==MISSED;
    }
    
    public boolean isUnguessed()
    {
        return status == UNGUESSED;
    }
    
    public void markHit()
    {
        status = HIT;
    }
    
    public void markMiss()
    {
        status = MISSED;
    }
    
    public boolean hasShip()
    {
        return this.hasShip;
    }
    
    public void setShip(boolean val)
    {
        hasShip = val;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return status;
    }
}
