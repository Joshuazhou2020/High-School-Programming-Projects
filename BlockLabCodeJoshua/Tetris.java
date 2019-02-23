
/**
 * Tetris class creates and maintains the Tetris board.
 * 
 * @author Joshua Zhou
 * @version January 17, 2019
 */
public class Tetris implements ArrowListener
{
    private MyBoundedGrid<Block> blocks;
    private BlockDisplay display;
    private Tetrad tetrad;
    
    /**
     * Constructs an object in the Tetris class.
     */
    public Tetris()
    {
        blocks=new MyBoundedGrid(20,10);
        display=new BlockDisplay(blocks);
        tetrad=new Tetrad(blocks);
        tetrad.translate(3,-2);
        display.setTitle("Joshua's Tetris");
        display.setArrowListener(this);
        display.showBlocks();
    }
    
    /**
     * Creates a new Tetris board.
     * 
     * @param   args    arguments from the command line
     */
    public static void main(String[] args)
    {
        Tetris test=new Tetris();
    }
    
    /**
     * 
     */
    @Override
    public void upPressed()
    {
        tetrad.translate(-1,0);
        display.showBlocks();
    }
    
    /**
     * 
     */
    @Override
    public void downPressed()
    {
        tetrad.translate(1,0);
        display.showBlocks();
    }
    
    /**
     * 
     */
    @Override
    public void leftPressed()
    {
        tetrad.translate(0,-1);
        display.showBlocks();
    }
    
    /**
     * 
     */
    @Override
    public void rightPressed()
    {
        tetrad.translate(0,1);
        display.showBlocks();
    }
    
    /**
     * 
     */
    @Override
    public void spacePressed()
    {
        while(tetrad.translate(1,0))
        {
            tetrad.translate(1,0);
        }
        display.showBlocks();
    }
}