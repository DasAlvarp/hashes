/**
 * Created by alvarpq on 18/11/15.
 *
 */
public class Main
{
    public static void main(String[] args)
    {

        //making stuff happen. Reset it a bunch to get all the things.
        System.out.print("60%");
        AlvarHash testHash = new AlvarHash(1019, false, 611, 10000);
        System.out.println(testHash.probeAndResults());
        testHash = new AlvarHash(1019, true, 611, 10000);
        System.out.println(testHash.probeAndResults());
        System.out.print("\n\n80%");
        testHash = new AlvarHash(1019, false, 819, 10000);
        System.out.println(testHash.probeAndResults());
        testHash = new AlvarHash(1019, true, 819, 10000);
        System.out.println(testHash.probeAndResults());
    }

}
