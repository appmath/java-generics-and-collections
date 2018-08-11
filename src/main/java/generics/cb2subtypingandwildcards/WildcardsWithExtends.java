package generics.cb2subtypingandwildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2.2. Wildcards with extends
 */
public class WildcardsWithExtends {
    public static void main(String[] args) {
        try {
            List<Number> nums = new ArrayList<Number>();
            List<Integer> ints = Arrays.asList(1, 2, 3);
            List<Double> doubles = Arrays.asList(1.2, 2.3, 3.3);
            nums.addAll(ints);
            nums.addAll(doubles);

            assert nums.toString().equals("[1, 2, 3, 1.2, 2.3, 3.3]");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
