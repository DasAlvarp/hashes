import java.util.LinkedList;

/**
 * Created by alvarpq on 18/11/15.
 */
public class Hash
{
    int[] hashList;
    boolean type;
    LinkedList<Integer> listToFill;
    Utils udler = new Utils();

    //constructor class for the hash.
    public Hash(int size, int fullNess, boolean probeType, int number, int range)
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
        for(int x = 0; x < listToFill.size(); x++)
        {
            int retPoint = retAddress(type, listToFill.get(x));
            if(hashList[retPoint] != 0)
            {
                x--;
                if(type)
                {
                    //quadratic! Will do later
                    retPoint += 5;
                }
                else
                {
                    retPoint++;
                }
            }
            else
            {
                hashList[retPoint] = listToFill.get(x);
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
            return key % hashList.length;
        }
    }



    public String hashAndGiveResults()
    {
        return "doot";
    }
}
