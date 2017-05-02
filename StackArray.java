package linear;
import java.util.*; 

public class StackArray <E> {
	//fields for the Stack data structure. 
	//this implementation is based on a fixed array of size 15, and every time 
	//it reaches capacity it creates a new array of type E double the initial size
	//and copy the old values to the new ones. 
	private int size = 5; 
	private E[] array; 
	private int top = -1; 
	
	public StackArray(){
		array = (E[]) new Object[size]; 
	}
	
	public E pop() {
		//method return top element from Stack. 
		if(top==-1){
			return null; 
		}else{
			E item = peek(); 
			array[top] = null; 
			top--; 
			return item; 
		}
	}

	public void push(E item) {
		//method that insert element into top of the stack
		if(size-1 == top){
			//when the array is already full. resize array, and put element
			//on top 
			resize(); 
			array[top+1]=item; 
			top = top+1; 
		}else{
			array[top+1]=item; 
			top = top+1; 
		}
	}

	
	public boolean isEmpty() {
		return top == -1; 
	}

	
	public E peek() {
		// return element from top of Stack without removing from the Stack. 
		E item = array[top]; 
		return item; 
	}
	
	private void resize(){
		E[] resizedArray = (E[]) new Object[size*2]; 
		for(int i=0; i<array.length; i++){
			resizedArray[i]=array[i]; 
		}
		array = resizedArray; 
		size = size*2; 
	}
}
