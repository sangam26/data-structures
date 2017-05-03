package linear;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

public class StackLinkedListTesting {
	StackLinkedList<Integer> numStack = new StackLinkedList<Integer>();
	
	@Before public void setup(){	
		numStack.push(4);
		numStack.push(5);
		numStack.push(1);
		numStack.push(6);
	}
	
	@Test 
	public void isPopped(){
		int num1 = numStack.pop(); 
		int num2 = numStack.pop(); 
		int num3 = numStack.pop(); 
		
		assertEquals(6, num1); 
		assertEquals(1, num2);
		assertEquals(5, num3);
	}
	
	@Test 
	public void minElement(){
		int min = numStack.minElement(); 
		assertEquals(1, min); 
	}
	

}
