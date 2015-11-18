import java.util.LinkedList;

/**
 * Created by alvarpq on 18/11/15.
 */
public class AlvarHash
{
    int[] hashList;
    boolean type;
    LinkedList<Integer> listToFill;
    Utils udler = new Utils();

    //constructor class for the hash.
    public AlvarHash(int size, boolean probeType, int number, int range)
    {
        hashList = new int[size];
        for(int x = 0; x < size; x++)
        {
            hashList[x] = 0;
        }
        type = probeType;
        listToFill = udler.getKeys(number, range);
        this.seed();
    }

    private void seed()
    {
        //iterate through all the things.
        int retPoint = retAddress(type, listToFill.get(0));

        for(int x = 0; x < listToFill.size() - 1; x=x)
        {
            if(hashList[retPoint] != 0)
            {
                if(type)
                {
                    //quadratic! Will do later
                    retPoint += 5;
                }
                else
                {
                    retPoint++;
                    retPoint = retPoint % 1019;
                }
            }
            else
            {
                hashList[retPoint] = listToFill.get(x);
                x++;
                retPoint = retAddress(type, listToFill.get(x));
            }
        }
    }

    private int retAddress(boolean type, int key)
    {
        if(type)
        {
            //yo man, quadratic is funky
            return 27;
        }
        else
        {
            return key % 1019;
        }
    }


    //a fancy way of deciding whther probe should be done linearly or quadratically.
    public String probeAndResults()//does probing and stuff. Probably gonna become a mess
    {
        if(type)
        {
            return quadraticProbeAndResults();
        }
        return linearProbeAnResults();
    }

    //see name
    private String linearProbeAnResults()
    {
        String tret = "doot";
        return tret;
    }

    //see name.
    private String quadraticProbeAndResults()
    {
        String tret = "";
        return tret;
    }
}
