package Backend;

public class Player
{
    // These are the lengths of all of the ships
    public static final int[] SHIP_LENGTHS ={2, 3, 3, 4, 5};
    private int MAX_HITSHOT = 0;
    private int countHitShot = 0;
    private int[] maxShipNum = new int[11];
    private int[] countShip= new int[6];
    private int numShipAdded = 0;
    private int length = 0;
     
    //instances variables
    private Grid playerGrid;
    private Grid enemyGrid;
    
    //construction 
    public Player()
    {
        updateMaxShipNum();
        setMaxShot();
        playerGrid = new Grid();
        enemyGrid = new Grid();
    }
    
    //methods 
    public void updateMaxShipNum()
    {
        for(int i=0; i<SHIP_LENGTHS.length; i++)
        {
            maxShipNum[SHIP_LENGTHS[i]]++;
        }
    }
    
    public int getHitShotNum()
    {
        return countHitShot;
    }
    
    public void setMaxShot()
    {
        for(int i=0; i<SHIP_LENGTHS.length; i++)
        {
            MAX_HITSHOT += SHIP_LENGTHS[i];
        }
    }
    
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        int length = s.getLength();
        if(countShip[length] < maxShipNum[length])
        {
            countShip[length]++;
            playerGrid.addShip(s);
        }
    }
    
    public int getShipsNum()
    {
        int sum = 0;
        for(int i=0; i<6; i++)
        {
            sum +=countShip[i];
        }
        return sum;
    }
    
    public Grid getGrid()
    {
        return playerGrid;
    }
    
    public Grid getEnemyGrid()
    {
        return enemyGrid;
    }
    
    public void printMyShips()
    {
        playerGrid.printShips();
    }
    
    public void printOpponentGuesses()
    {
        enemyGrid.printStatus();
    }
    
    public void printMyGuesses()
    {
        playerGrid.printShips();
    }
    
    public int getCurrentHit()
    {
        return countHitShot;
    }
    
    public int getMaxHit()
    {
        return MAX_HITSHOT;
    }
    
    public void recordOpponentGuess(int row, int col, Player enemy)
    {
        Grid enemyRealGrid = enemy.getGrid();
        if(enemyRealGrid.hasShip(row,col))
        {
            enemyGrid.setStatus(row, col, 1);
            countHitShot++;
        }
        else
        {
            enemyGrid.setStatus(row, col, 2);
        }
        System.out.println("");
    }
    
    // to check if the player can add the ship here or not 
    // only with the problem of the edge
    public boolean addShip(int row, int col, int direc)
    {
    	if(direc == 0)
    	{
    		if(col+SHIP_LENGTHS[length]-1 >= 10)
    		{
    			return false;
    		}
    		for(int i=0; i<SHIP_LENGTHS[length]; i++)
    		{
    			if(this.getGrid().hasShip(row, col+i))
    			{
    				return false;
    			}
    		}
    		for(int i=0; i<SHIP_LENGTHS[length]; i++)
    		{
    			this.getGrid().setShip(row, i+col, true);
    		}
    	}
    	else
        {
    		if(row+SHIP_LENGTHS[length]-1 >= 10)
    		{
    			return false;
    		}
            for(int i=0; i<SHIP_LENGTHS[length]; i++)
            {
            	if(this.getGrid().hasShip(i+row, col))
            	{
            		return false;
            	}
            }
            for(int i=0; i<SHIP_LENGTHS[length]; i++)
            {
                this.getGrid().setShip(i+row, col, true);
            }
        }
    	if(length<4)
    		length++;
    	numShipAdded ++;
    	return true;
    	
    	
    }
    
    // to return the ship Length of the current Ship
    public int getShipLength()
    {
    	return SHIP_LENGTHS[length];
    }
    
    // to set the OpponentGrid 
    public void setOpponentGrid(Grid grid)
    {
    	enemyGrid = grid;
    }
    
    public int getNumShipsAdded()
    {
    	return numShipAdded;
    }
    
    public boolean guess(int row, int col)
    {
    	if(this.getEnemyGrid().hasShip(row, col))
    	{
    		this.getGrid().setStatus(row, col, 1);
    		MAX_HITSHOT--;
    		return true;
    	}
    	else
    	{
    		this.getGrid().setStatus(row, col, 2);
    		return false;
    	}
    }
    
    public boolean alreadyGuessed(int row, int col)
    {
    	if(this.getGrid().getStatus(row,  col)==0)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public int opponentHitsRemaining()
    {
    	return MAX_HITSHOT;
    }
    
}
