/**
 * Created by alvarpq on 18/11/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        AlvarHash testHash = new AlvarHash(1019, true, 611, 10000);
        System.out.println(testHash.probeAndResults());
    }

}
