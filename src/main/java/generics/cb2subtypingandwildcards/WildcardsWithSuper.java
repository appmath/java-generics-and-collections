package generics.cb2subtypingandwildcards;

import java.util.Arrays;
import java.util.List;

/**
 * 2.3. Wildcards with super
 */
public class WildcardsWithSuper {
    public static void main(String[] args) {
        try {

            List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
            List<Integer> ints = Arrays.asList(1, 2);
            copy(objs, ints);
            assert objs.toString().equals("[1, 2, four]");


            List<? super Integer> intObjs = ints;
            String str = "";
            for (Object obj : intObjs) {
                str += obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // All the possible method signatures:
//    public static <T> void copy(List<? super T> dst, List<? extends T> src){
//    public static <T> void copy(List<T> dst, List<T> src) {
//    public static <T> void copy(List<T> dst, List<? extends T> src){
//    public static <T> void copy(List<? super T> dst, List<T> src){
    public static <T> void copy(List<? super T> dst, List<? extends T> src) {

        for (int i = 0; i < src.size(); i++) {
           dst.set(i, src.get(i));
        }
    }
}
