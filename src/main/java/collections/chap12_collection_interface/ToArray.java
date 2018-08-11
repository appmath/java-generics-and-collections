package collections.chap12_collection_interface;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 *
 *
 */
public class ToArray {

		public static void main(String[] args) {
				try {
						List l = Arrays.asList("one", "two");
						String[] a = (String[]) l.toArray(new String[0]);
				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
