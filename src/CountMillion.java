/**
 * Created by matthans on 2/8/17.
 */
public class CountMillion {
    public static void main(String [] args) {
        long start = System.currentTimeMillis();

        for (long x = 1; x <= 100000000000L; ++x) {

        }

        long end = System.currentTimeMillis();

         System.out.println("I counted to 1M in " + (end - start) + " milliseconds");
    }
}
