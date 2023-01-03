package Backend;

public class Grid
{
    // Copy over your Grid class into here
    private Location[][] grid;
    
    public static final int[] ROWS_HEAD = {1,2,3,4,5,6,7,8,9,10};
    public static final String[] COLS_SIDE = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    public String[][] ships = new String[10][12];
    public String[][] status = new String[10][12];
    
    //Construction
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int i=0; i< NUM_ROWS; i++)
        {
            for(int j=0; j< NUM_COLS; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
    }
    
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    public boolean alreadyGuessed(int row, int col)
    {
        return !(grid[row][col].getStatus()==0);
    }
    
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    
    public boolean hasShip(int row, int col)
    {
        return grid[row][col].hasShip();
    }
    
    public Location get(int row, int col)
    {
        return grid[row][col];
    }
    
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    public int numCols()
    {
        return NUM_COLS;
    }
    
    public void printStatus()
    {
        System.out.print("  ");
        for(int i=0; i<NUM_COLS-1; i ++)
        {
            System.out.print(ROWS_HEAD[i] + " "); 
        }
        System.out.print(ROWS_HEAD[9]); 
        System.out.println();
        for(int i=0; i< NUM_ROWS; i ++)
        {
            System.out.print(COLS_SIDE[i] + " ");
            for(int j=0; j< NUM_COLS; j++)
            {
                Location current = grid[i][j];
                if(current.getStatus() == 0)
                {
                    System.out.print("- ");
                }
                else if(current.getStatus() == 1)
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    
    public void printShips()
    {
        System.out.print("  1 ");
        for(int i=1; i<NUM_COLS-1; i ++)
        {
            System.out.print(ROWS_HEAD[i] + " "); 
        }
        System.out.print(ROWS_HEAD[9]); 
        System.out.println();
        for(int i=0; i<NUM_ROWS; i ++)
        {
            System.out.print(COLS_SIDE[i] + " ");
            for(int j=0; j< NUM_COLS; j++)
            {
                if(!grid[i][j].hasShip())
                {
                    System.out.print("- ");
                }
                else
                {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    
    public void addShip(Ship s)
    {
        int direction = s.getDirection();
        int row = s.getRow();
        int col = s.getCol();
        if(direction == 0)
        {
            for(int i=0; i<=s.getLength()-1; i++)
            {
                this.setShip(row, i+col, true);
            }
        }
        else
        {
            for(int i=0; i<=s.getLength()-1; i++)
            {
                this.setShip(i+row, col, true);
            }
        }
    }
    
    // this function will return a 2D array.
    // return String[][] board where we will 
    public String[][] getGridShips()
    {
    	
    	for(int i=0; i<=9; i++)
    	{
    		for(int j=0; j<=11; j++)
    		{
    			ships[i][j]="-";
    		}
    	}
    	for(int i=0; i<NUM_ROWS; i ++)
        {
    		ships[i][0] = COLS_SIDE[i];
            for(int j=1; j<= NUM_COLS; j++)
            {
                if(!grid[i][j-1].hasShip())
                {
                	ships[i][j] = "-";
                }
                else
                {
                	ships[i][j] = "X";
                }
            }
        }
    	return ships;
    }
    
    //this function will return a 2D array
    public String[][] getGridStatus()
    {
    	
    	for(int i=0; i<=9; i++)
    	{
    		for(int j=0; j<=11; j++)
    		{
    			status[i][j]="-";
    		}
    	}
    	for(int i=0; i< NUM_ROWS; i ++)
        {
    		status[i][0] = COLS_SIDE[i];
            for(int j=1; j<= NUM_COLS; j++)
            {
                Location current = grid[i][j-1];
                if(current.getStatus() == 0)
                {
                	status[i][j] = "-";
                }
                else if(current.getStatus() == 1)
                {
                	status[i][j] = "X";
                }
                else
                {
                	status[i][j] = "0";
                }
            }
        }
    	return status;
    	
    }
    
    
}
