package linear;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;
//******LinkedList data structure testing******///

public class LinkedListTesting {
	LinkedList<Integer> aList = new LinkedList<Integer>(); 
	LinkedList<Integer> aList2 = new LinkedList<Integer>();
	
	LinkedList<String> emptyList = new LinkedList<String>(); 
	private int lastPosition; 
	
	@Before public void setUp(){
	    aList.add(3);
	    aList.add(2);
	    
	    aList2.add(3);
	    aList2.add(2);
	    
	    lastPosition= aList.size()-1; 
	  }

	
	@Test 
	public void isRemovedFromLast(){
		//test if element is removed from the last order in the list 
		aList.remove();
		assertEquals(3, (int) aList.get(0)); 
		
		//test for empty list 
		emptyList.remove();
	}
	
	@Test
	public void isAddedToLast() {
		//test if element is added to last order of list 
		assertEquals(2, (int) aList.get(lastPosition)); 
	}
	
	@Test 
	public void isAddedAt(){
		//test if element has been added at specified index 
		//test if out bound index is handled properly. Negative included. 
		aList.addAt(6, 1);
		aList.addAt(7, 2); 
		assertEquals(6, (int) aList.get(1)); 
		assertEquals(7, (int) aList.get(2)); 
		
		//out of bound indexes 
		aList.addAt(1, -3);
		aList.addAt(1, 9);
		
		//adding at the front of the list 
		aList.addAt(0, 0);
		assertEquals(0, (int) aList.get(0)); 
	}
	
	@Test 
	public void isRemovedAt(){
		aList.add(4); 
		//test if it removes the first element from the list 
		aList.removeAt(0);
		assertEquals(2, (int) aList.get(0)); 
		aList.addAt(3, 0);
		assertEquals(3, (int) aList.get(0)); 
		
		
		//test if it removes from the middle of the list
		aList.removeAt(1);
		assertEquals(3, (int) aList.get(0)); 
		assertEquals(4, (int) aList.get(1)); 
		aList.addAt(2, 1);
		
		//test if it removes from the last element of list 
		aList.removeAt(2);
		assertEquals(2, (int) aList.get(1));
		
		//remove from out of bound index 
		aList.removeAt(5);
		aList.removeAt(-3);
	}
	
	@Test 
	public void size(){
		//test the size method for various add/remove function 
		assertEquals(2, aList.size()); 
		
		aList.add(4);
		assertEquals(3, aList.size()); 
		
		//aList.addAt(5, 3);
		//assertEquals(4, aList.size()); 
		
		//aList.remove();
		//assertEquals(3, aList.size()); 
		
		//aList.removeAt(2);
		//assertEquals(2, aList.size()); 
	}
	
	@Test 
	public void isReversed(){
		//test if linkedlist is reversed
		 
		aList.reverse();
		assertEquals(2, (int) aList.get(0)); 
		assertEquals(3, (int) aList.get(1)); 
	}
	
	@Test 
	public void split(){
		//test if returns the second half of the list
		aList.add(5);
		aList.add(6);
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp = aList.secondHalf(); 
		//even size; checking the returned list
		assertEquals(5, (int) temp.get(0));
		assertEquals(6, (int) temp.get(1));
		
		//even size; checking the original list
		assertEquals(3, (int) aList.get(0));
		assertEquals(2, (int) aList.get(1));
		
		//odd size; checking returned list 
		aList.remove();
		temp = aList.secondHalf(); 
		assertEquals(2, (int) temp.get(0));
		assertEquals(5, (int) temp.get(1));
		
		//odd size; checking original 
		assertEquals(3, (int) aList.get(0));
		assertEquals(2, (int) aList.get(1));
		
		
		
	}
	
	@Test
	public void isSame(){
		//test if two lists of same size contain same elements 
		assertEquals(true,aList.isSameSecondHalf(aList, aList2));
	}
	
	@Test 
	public void isPalindromeWithBuffer(){
		//test if a list is a palindrome. 
		
		//false case, even size
		aList.add(3);
		aList.add(5);
		assertEquals(false, aList.isPalindromeWithBuffer()); 
		
		//false case, odd size
		aList.add(6); 
		assertEquals(false, aList.isPalindromeWithBuffer()); 
		aList.remove();
		
		//true case, odd size
		aList.remove();
		assertEquals(true, aList.isPalindromeWithBuffer()); 
		
		//true case, even size
		aList.remove();
		aList.add(2);
		aList.add(3);
		aList.size(); 
		assertEquals(true, aList.isPalindromeWithBuffer()); 
		
		//for 1 element in the list 
		aList.remove();
		aList.remove();
		aList.remove();
		assertEquals(true, aList.isPalindromeWithBuffer()); 
	}
}
