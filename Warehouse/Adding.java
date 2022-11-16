public class Adding implements Runnable 
{
    private Thread threads;
    private String threadx;
    private InventoryMain hWarehouse;   // creating an instance by making a variable name
    private static final Object lock = new Object(); 

    private boolean isBug;

    Adding(String x, InventoryMain h, int bugFlag) 
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
                hWarehouse.add();
                hWarehouse.size();
                System.out.println("Added. Inventory size: " + hWarehouse.size());
            }
        }
        else
        {
            hWarehouse.add();
            hWarehouse.size();
            System.out.println("Added. Inventory size: " + hWarehouse.size());
        }
    }
}