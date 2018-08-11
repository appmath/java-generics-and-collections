package generics.cb2subtypingandwildcards;

import java.util.Arrays;
import java.util.List;

/**
 * 2.6. Wildcards Versus Type Parameters
 *
 */
public class WildcardsVersusTypeParameters {
    public static void main(String[] args) {
        try {

            Object obj = "one";
            List<Object> objs = Arrays.<Object>asList("one", 1, 2);
            List<Integer> ints = Arrays.asList(2, 4);
            assert objs.contains(objs);
            assert objs.contains(ints);
            assert !ints.contains(obj);
            assert !ints.contains(objs);

             obj = 1;
            objs = Arrays.<Object>asList(1, 3);
            ints = Arrays.asList(1, 2, 3, 4);
            assert ints.contains(obj);
            assert ints.containsAll(objs);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


