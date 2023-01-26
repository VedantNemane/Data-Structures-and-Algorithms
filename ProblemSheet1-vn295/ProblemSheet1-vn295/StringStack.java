import java.lang.reflect.Array;

/** A stack abstract data type that contains Strings. */
public class StringStack {
	// TODO add variables for data here
	int topPosition, capacity;
	String[] stack;
	/**
	* Constructor for creating a new StringStack with a certain capacity.
	* @param capacity the maximum number of strings the stack can hold
	*/
	public StringStack(int capacity) {
		// TODO implement this
		topPosition = 0;
		this.capacity = capacity;
		stack = new String[capacity + 1];
	}
	
	/**
	* Puts the given String on top of the stack (if there is enough space).
	* @param s the String to add to the top of the stack
	* @return false if there was not enough space in the stack to add the string;
	*         otherwise true
	*/
	public boolean push(String s) {
		if (topPosition < capacity){
			stack[topPosition + 1] = s;
			topPosition = topPosition + 1;
			return true;
		}
		return false;
	}
	
	/**
	* Removes the String on top of the stack from the stack and returns it.
	* @return the String on top of the stack, or null if the stack is empty.
	*/
	public String pop() {
		if (topPosition - 1 > -1){
			String s = stack[topPosition];
			stack[topPosition] = "";
			topPosition = topPosition - 1;
			return s;
		}
		return null;
	}
	
	/**
	* Returns the number of Strings in the stack.
	* @return the number of Strings in the stack
	*/
	public int count() {
		return topPosition;
	}
}
