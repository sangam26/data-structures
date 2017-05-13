package linear;

public class queueArray<E> {
	
private E[] array; 
private int capacity=5;  
private int numElement=0; 
private int front; 
private int back; 

	public queueArray(){
		array = (E[]) new Object[capacity]; 
		front=0; 
		back=-1; 
	}
	
	public boolean isEmpty() {
		return numElement == 0; 
	}

	
	public E getFront() {
		if(isEmpty()){
			return null; 
		}else{
			return array[front%capacity]; 
		}
	}

	
	public E dequeue() {
		E item = getFront();  
		array[front%capacity]=null; 
		front++; 
		numElement--; 
		return item; 
	}	

	
	public void enqueue(E item) {
		if(numElement==capacity) resize(); 
		back++; 
		array[back%capacity]=item; 
		numElement++; 
	}

	
	public void clear() {
		for (int i=0; i<capacity; i++) array[i]=null; 
		 front=0; 
		 back=-1; 
		 numElement=0; 
	}
	
	private void resize(){
		//copy item from front to back 
		E[] resizedArray = (E[]) new Object[2*capacity];
		for(int i=front; i<=back; i++){
			resizedArray[i-front]=array[i%capacity];
		}
		array = resizedArray; 
		front=0; 
		back=numElement-1; 
		capacity=2*capacity;
		
	}
}
