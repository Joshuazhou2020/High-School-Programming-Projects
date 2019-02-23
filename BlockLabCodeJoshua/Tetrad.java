import java.awt.Color;
import java.util.ArrayList;

/**
 * Tetrad class controls the blocks in the Tetris board.
 * 
 * @author Joshua Zhou
 * @version January 17, 2019
 */
public class Tetrad
{
    private Block[] blocks;
    private MyBoundedGrid<Block> gr;
    private String[] types;
    private Color[] colors;
    private int shape;
    
    /**
     * Constructs an object in the Tetrad class.
     * 
     * @param   grid    the grid in which the object is to be added
     */
    public Tetrad(MyBoundedGrid<Block> grid)
    {
        gr=grid;
        blocks=new Block[4];
        types=new String[]{"I","T","O","L","J","S","Z"};
        colors=new Color[]{Color.RED,Color.GRAY,Color.CYAN,
            Color.YELLOW,Color.MAGENTA,
            Color.BLUE,Color.GREEN};
        shape=(int)(Math.random()*types.length);

        int mid=grid.getNumCols()/2;
        Location[] locs=new Location[4];
        String letter=types[shape];
        if (letter.equals("I"))
        {
            locs[0]=new Location(0,mid);
            locs[1]=new Location(1,mid);
            locs[2]=new Location(2,mid);
            locs[3]=new Location(3,mid);
        }
        if (letter.equals("T"))
        {
            locs[0]=new Location(0,mid-1);
            locs[1]=new Location(0,mid);
            locs[2]=new Location(0,mid+1);
            locs[3]=new Location(1,mid);
        }
        if (letter.equals("O"))
        {
            locs[0]=new Location(0,mid-1);
            locs[1]=new Location(1,mid-1);
            locs[2]=new Location(0,mid);
            locs[3]=new Location(1,mid);
        }
        if (letter.equals("L"))
        {
            locs[0]=new Location(0,mid);
            locs[1]=new Location(1,mid);
            locs[2]=new Location(2,mid);
            locs[3]=new Location(2,mid+1);
        }
        if (letter.equals("J"))
        {
            locs[0]=new Location(0,mid);
            locs[1]=new Location(1,mid);
            locs[2]=new Location(2,mid);
            locs[3]=new Location(2,mid-1);
        }
        if (letter.equals("S"))
        {
            locs[0]=new Location(0,mid);
            locs[1]=new Location(1,mid);
            locs[2]=new Location(0,mid+1);
            locs[3]=new Location(1,mid-1);
        }
        if (letter.equals("Z"))
        {
            locs[0]=new Location(0,mid);
            locs[1]=new Location(1,mid);
            locs[2]=new Location(1,mid+1);
            locs[3]=new Location(0,mid-1);
        }
        addToLocations(grid,locs);
    }
    
    /**
     * Adds blocks to specific locations.
     * 
     * @param   grid    the grid in which the blocks are to be added
     * @param   locs    the locations at which the blocks are to be added
     */
    public void addToLocations(MyBoundedGrid<Block> grid,Location[] locs)
    {
        for(int i=0;i<blocks.length;i++)
        {
            blocks[i]=new Block();
            blocks[i].setColor(colors[shape]);
            blocks[i].putSelfInGrid(grid,locs[i]);
        }
    }
    
    /**
     * 
     */
    private Location[] removeBlocks()
    {
        int len=blocks.length;
        Location[] locs=new Location[len];
        for(int i=0;i<len;i++)
        {
            locs[i]=blocks[i].getLocation();
            blocks[i].removeSelfFromGrid();
        }
        return locs;
    }
    
    /**
     * 
     */
    private boolean areEmpty(MyBoundedGrid<Block> grid,Location[] locs)
    {
        ArrayList<Location> locations=grid.getOccupiedLocations();
        boolean space=true;
        for(int i=0;i<locs.length;i++)
        {
            for(int j=0;j<locs.length;j++)
            {
                if(locs[j].equals(locs[i]))
                {
                    space=false;
                }
            }
            if(!grid.isValid(locs[i])||!space)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     */
    public boolean translate(int deltaRow,int deltaCol)
    {
        Location[] locs=removeBlocks();
        Location[] temp=new Location[locs.length];
        for(int i=0;i<locs.length;i++)
        {
            int newRow=locs[i].getRow()+deltaRow;
            int newCol=locs[i].getCol()+deltaCol;
            Location newLocation=new Location(newRow,newCol);
            temp[i]=newLocation;
        }
        if(areEmpty(gr,locs))
        {
            addToLocations(gr,temp);
            return true;
        }
        addToLocations(gr,locs);
        return false;
    }
}