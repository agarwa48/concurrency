import java.util.concurrent.TimeUnit;

public class InventoryMain
{
    public int addedInt;
    public int removedInt;

    public int i; 
    public int j;
    public int currentSize = 0; 

    public void add()
    {
        currentSize ++;
    }

    public void sub()
    {
        currentSize --;
    }

    public int size()
    {
        return currentSize;
    }
  
    public static void main(String[] args) 
    {  
        // command line arguments 
        int addedInt = Integer.parseInt(args[0]); 
        int removedInt = Integer.parseInt(args[1]);
        int bugFlag = Integer.parseInt(args[2]);

        // making instances 
        InventoryMain wh = new InventoryMain();
        Adding add = new Adding("add ", wh, bugFlag);
        Subtracting sub = new Subtracting("sub ", wh, bugFlag);

        // making thread arrays that stores the commands as strings
        Thread[]  addThreads = new Thread[addedInt];
        Thread[]  subThreads = new Thread[removedInt];
        

        for(int i = 0; i < addedInt; i++)
        { 
            addThreads[i] = new Thread(add);
            addThreads[i].start();
        }

        for(int j = 0; j < removedInt; j++)
        {
            subThreads[j] = new Thread(sub);
            subThreads[j].start();
        }

        // waits for all other threads to be completed before printing
        for(Thread t : addThreads)
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {}
            
        }
        // joining both the threads
        for(Thread t : subThreads)
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {}
        }

        System.out.println("Final Invenotory size: " + wh.currentSize);


    }

}


