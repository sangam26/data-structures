package linear;

public class StackLinkedList<E> {
	private int size; 
	private Node<E> top; 
	
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
		size++; 
	}
	
	public boolean isEmpty(){
		return size == 0; 
	}
	
	public E peek(){ 
		return top.data; 
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
