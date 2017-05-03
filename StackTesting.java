package linear;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

public class StackTesting {
	StackArray<Integer> myStack = new StackArray<Integer>(); 
	StackArray<Integer> emptyStack = new StackArray<Integer>();
	@Before public void setup(){
		myStack.push(3);
		myStack.push(5);
		myStack.push(9);
		myStack.push(94);
		myStack.push(5);
		myStack.push(11);
	}
	
	
	@Test 
	public void isPopped(){
		int num1 = myStack.pop(); 
		int num2 = myStack.pop();
		int num3 = myStack.pop();
		
		assertEquals(11, num1); 
		assertEquals(5, num2);
		assertEquals(94, num3);
	}
	
	@Test
	public void minElement(){
		int min = myStack.minElement();
		int min2 = emptyStack.minElement(); 
		
		assertEquals(3, min); 
		assertEquals(Integer.MAX_VALUE, min2); 
		
	}
}
