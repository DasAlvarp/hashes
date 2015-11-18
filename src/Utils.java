import java.util.LinkedList;
import java.util.Random;

/**
 * Created by alvarpq on 18/11/15.
 */
public class Utils
{
    //returns a linkedlist with numbers from 0 to range, a number of times.
    public LinkedList<Integer> getKeys(int number, int range)
    {
        LinkedList<Integer> nums = new LinkedList<>();
        Random randy = new Random();

        int tempX;
        for(int x = 0; x < number + 1; x++)
        {
            tempX = randy.nextInt(range) + 1;
            if(nums.contains(tempX))
            {
                x--;
            }
            else
            {
                nums.add(tempX);
            }
        }
        return nums;
    }
}
