package linear;

public class queueLinkedList<E> {
	private Node<E> head; 
	private Node<E> tail;
	private int numElement; 
	
	public queueLinkedList(){
		numElement = 0; 
	}
	
	public void enqueue(E item){
		Node<E> aNode = new Node<E>(item); 
		Node<E> temp = head; 
		if(numElement==0){
			head=aNode;
			tail=aNode; 
		}else{
			tail.next = aNode;  
			tail =aNode;
		}
		numElement++;
	}
	
	public void clear(){
		head = null; 
		tail=null; 
		numElement =0; 
	}
	
	public boolean isEmpty(){
		return numElement == 0; 
	}
	
	public E dequeue(){
		E data = head.data; 
		Node<E> temp = head; 
		if(!isEmpty()){
			head = head.next; 
			temp.next = null; 
			numElement--;
		}
		return data; 
	}
	
	public E getFront(){
		return head.data; 
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
