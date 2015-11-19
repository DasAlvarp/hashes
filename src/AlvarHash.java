import java.util.LinkedList;

/**
 * Created by alvarpq on 18/11/15.
 */
public class AlvarHash
{
    int[] hashList;
    boolean type;
    LinkedList<Integer> listToFill; //list of keys to FILL the hash. See? I make sense.
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
        int retPoint = retAddress(listToFill.get(0));
        int tret = retPoint;
        int range = 0;

        //filling list. X is only incremented when something's placed sucessfully.
        for(int x = 0; x < listToFill.size() - 1; x = x)
        {
            if(hashList[retPoint] != 0)
            {
                if(type)
                {
                    if(range > 0)//alternating return
                    {
                        retPoint = (tret + (int) Math.pow((double) range, 2.0)) % 1019;
                        range *= -1;
                    }
                    else
                    {
                        retPoint = (tret - (int) Math.pow((double) range, 2.0));
                        while(retPoint < 0)
                        {
                            retPoint += 1019;
                        }

                        range -= 1;
                    }
                }
                else//nice and easy input.
                {
                    retPoint++;
                    retPoint = retPoint % 1019;
                }
            }
            else
            {
                //resetting stuff after stuff thrown into hash.
                hashList[retPoint] = listToFill.get(x);
                x++;
                range = 0;
                retPoint = retAddress(listToFill.get(x)) % 1019;
                tret = retPoint;
            }
        }

    }

    private int retAddress(int key)//retunrs address. Silly.
    {
        return key % 1019;
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
        double sucessNum = 0;
        double sucessProbeNum = 0;

        double failNum = 0;
        double failProbeNum = 0;

        //looping thru all the possible keys. RIP.
        for(int x = 0; x < 10000; x++)
        {
            int probes = 0;
            boolean successful = false;
            //for loop that should be a while loop. Sets initial value for y, also increments it, stops when hashlist hits something that's empty.
            for(int y = x % 1019; hashList[y] != 0; y = (y + 1) % 1019)
            {
                probes++;
                if(hashList[y] == x)
                {
                    successful = true;
                    break;
                }

            }

            //managing stats
            if(successful)
            {
                sucessNum++;
                sucessProbeNum += probes;
            }
            else
            {
                failNum++;
                failProbeNum += probes;
            }
        }
        double failRate = failProbeNum / failNum;
        double sucessRate = sucessProbeNum / sucessNum;


        String tret = "\nLinear probe: \nAverage probes to fail: " + failRate + "\nAverage probes to suceed: " + sucessRate;

        return tret;
    }

    //see name.
    private String quadraticProbeAndResults()
    {
        double sucessNum = 0;
        double sucessProbeNum = 0;

        double failNum = 0;
        double failProbeNum = 0;


        //through all possible keys
        for(int x = 0; x < 10000; x++)
        {
            int probes = 0;
            boolean successful = false;
            int range = 1;
            int checkPlace = x % 1019;//checkplace is basically Y for when Y has to be edited by i

            //for loop that shouln't be a for loop.
            for(int y = x % 1019; hashList[checkPlace] != 0; y = y)
            {
                probes++;
                if(hashList[checkPlace] == x)
                {
                    successful = true;
                    break;
                }
                if(range > 1)
                {
                    //alternating L. Alternates and stuff
                    checkPlace = (y + (int)Math.pow((double)range, 2.0)) % 1019;
                    range *= -1;
                }
                else
                {
                    checkPlace = (y - (int)Math.pow((double)range, 2.0)) % 1019;
                    while(checkPlace < 0)
                    {
                        checkPlace += 1019;
                    }
                    range -= 1;
                }

            }

            //managing stats
            if(successful)
            {
                sucessNum++;
                sucessProbeNum += probes;
            }
            else
            {
                failNum++;
                failProbeNum += probes;
            }
        }
        double failRate = failProbeNum / failNum;
        double sucessRate = sucessProbeNum / sucessNum;


        String tret = "\nQuadratic Probing: \nFail rate: " + failRate + "\nSucess rate: " + sucessRate;

        return tret;
    }
}
