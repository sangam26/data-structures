package linear;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

public class StackTesting {
	StackArray<Character> myStack = new StackArray<Character>(); 
	@Before public void setup(){
		myStack.push('s');
		myStack.push('a');
		myStack.push('n');
		myStack.push('g');
		myStack.push('a');
		myStack.push('m');
	}
	
	
	@Test 
	public void isPopped(){
		char aChar1 = myStack.pop(); 
		char aChar2 = myStack.pop();
		char aChar3 = myStack.pop();
		
		assertEquals('m', aChar1); 
		assertEquals('a', aChar2);
		assertEquals('g', aChar3);
	}
}
