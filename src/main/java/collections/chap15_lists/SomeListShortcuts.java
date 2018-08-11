package collections.chap15_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description
 *
 *
 */
public class SomeListShortcuts {
		public static void main(String[] args) {
				try {
						List<Character> charList = new ArrayList<>();
						Collections.addAll(charList, 'a', 'b', 'c');
				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
