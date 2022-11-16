public class Subtracting implements Runnable 
{
    private Thread threads;
    private String threadx;
    private InventoryMain hWarehouse; 
    private static final Object lock = new Object(); 
    private boolean isBug;

    Subtracting(String x, InventoryMain h, int bugFlag) 
    {
        threadx = x;
        this.hWarehouse = h; 
        if(bugFlag == 0) isBug = false;
        else isBug = true;
    }

    public void run() 
    { 
        if(!isBug)
        {
            synchronized(lock)
            {
                hWarehouse.sub();
                hWarehouse.size();
                System.out.println("Removed. Inventory size: " + hWarehouse.size());
            }
        }

        else
        {
            hWarehouse.sub();
            hWarehouse.size();
            System.out.println("Removed: Inventory size: " + hWarehouse.size());
        }
    }
}