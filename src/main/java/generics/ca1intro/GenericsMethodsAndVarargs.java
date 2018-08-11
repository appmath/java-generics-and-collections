package generics.ca1intro;

import java.util.ArrayList;
import java.util.List;

/**
 * Listing
 */
public class GenericsMethodsAndVarargs {



    private static class Lists {
        public static <T> List<T> toList(T... arr) {
            List<T> list = new ArrayList<T>();
            for (T t : list) list.add(t);
            return list;
        }
    }
}
