package linear;
import java.util.*; 

public class StackArray <E> {
	//fields for the Stack data structure. 
	//this implementation is based on a fixed array of size 15, and every time 
	//it reaches capacity it creates a new array of type E double the initial size
	//and copy the old values to the new ones. 
	private int capacity = 5; 
	private int numElement = 0; 
	private E[] array; 
	private int min=0; 
	private int top = -1;  
	
	public StackArray(){
		array = (E[]) new Object[capacity]; 
	}
	
	public E pop() {
		//method return top element from Stack. 
		if(top==-1){
			return null; 
		}else{
			E item = peek(); 
			array[top] = null; 
			top--; 
			numElement--; 
			minElement(); 
			return item; 
		}
	}

	public void push(E item) {
		//method that insert element into top of the stack
		if(capacity-1 == top){
			//when the array is already full. resize array, and put element
			//on top 
			resize(); 
			array[top+1]=item; 
			top = top+1; 
		}else{
			array[top+1]=item; 
			top = top+1;  
		}  
		numElement++; 
		minElement(); 
	}

	
	public boolean isEmpty() {
		return top == -1; 
	}

	
	public E peek() {
		// return element from top of Stack without removing from the Stack. 
		E item = array[top]; 
		return item; 
	}
	
	public int minElement(){ 
		if(isEmpty()){
			return Integer.MAX_VALUE; 
		}else if(numElement==1){
			min = (int) array[top]; 
		}
		else{
			if(min > (int) array[top]){
				min = (int) array[top]; 
			}
		}
		return min; 
		}

	private void resize(){
		//double size of array when original array is full. 
		E[] resizedArray = (E[]) new Object[capacity*2]; 
		for(int i=0; i<array.length; i++){
			resizedArray[i]=array[i]; 
		}
		array = resizedArray; 
		capacity = capacity*2; 
	}
}
