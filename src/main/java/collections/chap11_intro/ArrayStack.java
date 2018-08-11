package collections.chap11_intro;

/**
 * Description
 *
 *
 */
public class ArrayStack implements Stack {

		private final int MAX_ELEMENTS = 10;
		private int[] stack;
		private int index;

		public ArrayStack() {
				stack = new int[MAX_ELEMENTS];
				index = -1;
		}

		@Override
		public void push(int elt) {
				if(index != stack.length -1) {
						index++;
						stack[index] = elt;
				} else {
						throw new IllegalStateException("Stack overflow!");
				}
		}

		@Override
		public int pop() {
				if (index != -1) {
						final int stack = this.stack[index];
						index--;
						return stack;
				} else {
				    throw new IllegalAccessError("Stack underflow");
				}
		}

		@Override
		public boolean isEmpty() {
				return index == -1;
		}
}
