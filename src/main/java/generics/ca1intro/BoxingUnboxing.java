package generics.ca1intro;

import java.util.Arrays;
import java.util.List;

/**
 * Listing
 */
public class BoxingUnboxing {

    public static Integer sumInteger(List<Integer> ints){
        Integer s = 0;
        for (Integer n : ints) {
            s=+n;
        }
         return s;
    }
    public static int sumInt(List<Integer> ints){
        int s = 0;
        for (int n : ints) {
            s=+n;
        }
         return s;
    }


    public static void main(String[] args) {
        try {
            List<Integer> bigs = Arrays.asList(100, 200, 300);
            assert sumInteger(bigs) == sumInt(bigs);  // it's OK, unboxing saves the day!
            assert sumInteger(bigs) != sumInteger(bigs);  // not recommended because it compares the memory address.

            List<Integer> smalls = Arrays.asList(1, 2, 3);
            assert sumInteger(smalls) == sumInt(smalls);

						// A further subtlety is that boxed values may be cached. Caching is required when boxing an int or short
						// value between–128 and 127, a char value between '\u0000' and '\u007f', a byte, or a boolean; and caching
						// is permitted when boxing other values.
            assert sumInteger(smalls) == sumInteger(smalls);  // not recommended: numbers /b/ -128 to 127 are cached.


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
