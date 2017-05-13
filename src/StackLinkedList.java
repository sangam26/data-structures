package linear;

public class StackLinkedList<E> {
	private int size; 
	private Node<E> top; 
	private int min =0; 
	
	public StackLinkedList(){
		size=0; 
	}
	
	public E pop(){
		if(size==0){
			return null; 
		}else{
			Node<E> temp = top; 
			top = temp.next; 
			size--; 
			return temp.data;
		}
	}
	
	public void push(E item){
		Node<E> aNode = new Node<E>(item);
		if(size==0){
			top = aNode; 
		}else{
			aNode.next = top; 
			top = aNode; 
		}
		minElement(); 
		size++; 
	}
	
	public boolean isEmpty(){
		return size == 0; 
	}
	
	public E peek(){ 
		return top.data; 
	}
	
	public int minElement(){
		//return minimum integer from the Stack. 
		if(isEmpty()){
			return min = Integer.MAX_VALUE; 
		}
		else if(size==1){
			min = (int) top.data; 
		}else{
			if(min > (int) top.data){
				min = (int) top.data; 
			}
		}
		return min; 
	}
	
	private static class Node<E>{
		Node<E> next; 
		E data; 
		
		public Node(E data){
			this.data = data;  
			next = null; 
		}
	}
	

}
