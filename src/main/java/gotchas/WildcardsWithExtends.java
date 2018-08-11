package gotchas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2.2. Wildcards with extends
 */
public class WildcardsWithExtends {
    public static void main(String[] args) {
        try {
            List<Integer> ints = Arrays.asList(1, 2, 3);
            List<? extends Number> nums = ints;

            // This:  nums.add(2);
            // or EVEN this: nums.add(((Number) Integer.valueOf(2)));
            // throws this:
            //java: no suitable method found for add(java.lang.Number)
//            method java.util.List.add(int,capture#1 of ?extends java.lang.Number)is not applicable
//                    (actual and formal argument lists differ in length)
//            method java.util.List.add(capture#1of ?extends java.lang.Number)is not applicable
//                    (actual argument java.lang.Number cannot be converted to capture#1of ?extends java.lang.Number by
//            method invocation conversion)

            // Why:
            // In general, if a structure contains elements with a type of the form ? extends E,
            // we can get elements out of the structure, but we cannot put elements into the structure.
            // To put elements into the structure we need another kind of wildcard, as explained in the next section

            // The only exception to this rule:supInt
            nums.add(null);


            List<? super Integer> supNums = new ArrayList<Number> (ints);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
