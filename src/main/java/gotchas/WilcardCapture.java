package gotchas;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.7. Wildcard Capture gotchas
 */
public class WilcardCapture {

    public static <T> void  reverse(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    // This will not work: we are trying to write from a list of objects into a
    // list of unknown type. Replacing List<Object> with List<?> won’t fix the problem,
    // because now we have two lists with (possibly different) unknown element types.
//    public static void reverse(List<?> list) {
//        List<Object> tmp = new ArrayList<Object>(list);
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, tmp.get(list.size() - i - 1));  // compile-time error
//        }
//    }


    // This is the workaround! Here we say that the type variable T has captured the wildcard
    public static void reverse2(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

}
