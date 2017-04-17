package linear;

import java.util.*; 

public class LinkedList <E> implements Iterable<E>  {
	//LINKEDLIST CLASS//
	//private fields for linked list 
	private int counter;  
	private Node<E> head; 
	
	public LinkedList(){
		//default class constructor 
		head= new Node<E> (null); 
		counter=0; 
	}
	
	//getters and setters
	public int getCounter(){
		return this.counter; 
	}
	public void incrementCount(){
		counter++; 
	}
	public void decreaseCount(){
		counter--; 
	}
	 
	
	public void add(E data){
		//add a node to the end of the list 
		Node<E> newNode = new Node(data); 
		Node<E> temp = head;  
		if(head==null){
			head = newNode; 
		} else{
		while (temp.next != null){
			temp = temp.next; 
		}
		temp.next = newNode; 	
	}
	incrementCount(); 
	}
	
	public boolean addAt(E data, int index){
		//add object at specified index
		Node<E> newNode = new Node(data); 
		Node<E> temp = head; 
		boolean hasBeenAdded = true; 
		int currentIndex=0; 
		
		if(index < 0 || index > size()){
			hasBeenAdded = false; 
		}else{
			if(temp.next != null){
				for(int i=0; i<index; i++){
					temp = temp.next; 
				}
			}
			newNode.next = temp.next; 
			temp.next = newNode; 
			incrementCount(); 
		}
		return hasBeenAdded; 
	}
	
	public void remove(){
		//remove a node from the last element in the list. 
		
		Node temp = head; 
		if(size()==0){
			//do nothing
		}else{
			while(temp.next.next != null){
				temp = temp.next; 
			}
			temp.next = null; 
		}
		decreaseCount(); 
	}
	
	public boolean isPalindromeWithoutBuffer(){
		//check if LinkedList is a Palindrome. This directly affects the list so 
		//the original list is modified. 
		//setting up pointers and variables.
		int middle = size()/2; 
		Node<E> curr, nextNode, secondHead, pre;
		pre = head; 
		int counter = 0; 
		if(size()>1){
			curr = head.next; 
			nextNode = head.next.next; 
		}else{
			//1 or empty element, so return always true. 
			return true; 
		}
		
		//locate index from where to reverse; reverse the second half of the list 
 		if(size()%2==0){
 			//move all pointers to the second half of the list. curr pointer is pointing 
 			//to the first node in the second half of the list. 
 			 
 			if(size()>2){
 				//for even size with more than 2 elements. Base case 4 elements.
 				while(counter != middle){
 					pre = pre.next; 
 					curr = curr.next; 
 					nextNode = nextNode.next; 
 					counter++; 
 				}
 				pre.next = null; 
 				
 				secondHead = this.reverseFrom(curr);
 				
 			}else{
 				//for even size, with 2 elements. Just compare if the two elements is the same. 
 				if(curr.data == nextNode.data){
 					return true; 
 				}else{
 					return false; 
 				}
 			}
		}else{
			//for odd size. Base case is 3 elements. 
			while(counter != middle + 1){
					pre = pre.next; 
					curr = curr.next; 
					nextNode = nextNode.next; 
					counter++; 
				}
			pre.next = null; 
			
			secondHead = this.reverseFrom(curr);
		}
 		//go through list and compare the two halves. 
 		if(isSame(head, secondHead)){
 			return true;
 		}else{
 			return false; 
 		}
	}
	
	private Node<E> reverseFrom(Node<E> aNode){
		//take a Node pointer and reverse the list from the given node. return 
		//head node of the reversed list. 
		Node<E> pre, curr, nextNode, headSecondHalf; 
		 headSecondHalf = new Node(null);
		pre = null; 
		
		if(size()<=1){
			// do nothing
		}else{
			curr = aNode; 
			nextNode = aNode.next;  
			while(nextNode != null){
				curr.next = pre; 
				
				//move all three pointers to the right 
				pre = curr; 
				curr = nextNode; 
				nextNode = nextNode.next; 
			}
			//relink last node 
			headSecondHalf.next = curr; 
			curr.next = pre; 
		}
		
		return headSecondHalf; 
	}
	
	public boolean removeAt(int index){
		//remove Node from the specified index.  
		Node<E> previous = head; 
		Node<E> temp = null; 
		int currentIndex = 0; 
		boolean hasBeenRemoved = true; 
		
		if(index<0 || index > size()){
			//check out of bound index
			return false; 
		}	
		if(size()==0){
			//do nothing if empty list 
		}else{
			temp = head.next; 
			while(index != currentIndex){
				previous = previous.next; 
				temp = temp.next; 
				currentIndex++; 
			}
			previous.next = temp.next;
			decreaseCount(); 
		}
		
		return hasBeenRemoved; 
	}
	
	public void reverse(){
		//reverse the linkedlist 
		Node<E> previous, curr, nextNode; 
		previous = null; 
		curr = head.next; 
		
		if(size()<=1){
			//do nothing
			}else{
				nextNode = head.next.next;  
				
				while(nextNode != null){
					curr.next = previous; 
					
					//move all three pointer to the right
					previous = curr; 
					curr = nextNode; 
					nextNode = nextNode.next; 
				}
				//relink last node of the list.
				
				curr.next = previous; 
				head.next = curr; 
				
			}
		}
	
	public LinkedList<E> secondHalf(){
		//split a LinkedList in two equal size, and return the second half of the original 
		//LinkedList. 
		int middle = size()/2;
		LinkedList<E> secondHalf = new LinkedList<E>(); 
		Node<E> temp = head.next; 
		int count = 0; 
		//move head to the middle of the list. 
		while(count != middle){
			temp = temp.next; 
			count++; 
		}
		//start populating the list from the middle 
		while(temp != null){
			secondHalf.add(temp.data);
			temp = temp.next; 
		}
		return secondHalf; 	
	}
	
	public boolean isSameSecondHalf(LinkedList<E> firstList, LinkedList<E> secondList){
		//compare the second half of the list with the first half. 
		//if the two lists have the exact same element in the exact same order. 
		Iterator<E> iterator1 = firstList.iterator();  
		Iterator<E> iterator2 = secondList.iterator(); 
		
		while(iterator1.hasNext() && iterator2.hasNext() ){
			if(iterator1.next()!=iterator2.next()){
				return false; 
			}
		}
		return true;
	}
	
	public boolean isSame(Node<E> head1, Node<E> head2){
		//take two heads and compare the value of each node. Return true if 
		//each lists has same elements in same order. 
		Node<E> temp1 = head1; 
		Node<E> temp2 = head2; 
		while(temp1.next!=null){
			if(temp1.data != temp2.data){
				return false; 
			}
			temp1 = temp1.next;
			temp2 = temp2.next; 
		}
		return true; 
	}
		

	public boolean isPalindromeWithBuffer(){
		//method that returns true if the list is a palindrome. False otherwise. 
		//this method uses a buffer, used by the helper function secondHalf. 
		//Think of a solution without using a buffer. 
		LinkedList<E> secondHalf = new LinkedList<E>();
		secondHalf = this.secondHalf(); 
		secondHalf.reverse(); 
		if(secondHalf.isSameSecondHalf(this, secondHalf)){
			return true; 
		}else{
			return false; 
		}
	}
			
	public int size(){
		return this.counter; 
	}
	
	public E get(int index){
		//deal when index input is negative
		Node<E> temp = head; 
		if (index<0 || index>size()){
			System.out.println("index out of bound"); 
			return null; 
		}
		//move header when there is only elements in the list
		if(size()>=0){
			for(int i=0; i<=index; i++){
				temp = temp.next; 
			}
			return  temp.getData(); 
		}else{
			return null; 
		}
	}
	
	private static class Node<E>{
		//NODE CLASS//
		Node<E> next; 
		E data; 
		
	public Node (E data){
		next = null; 
		this.data = data; 
	}
	
	//getters and setters BEGIN
	public E getData(){
		return this.data; 
	}
	public E setData(E dataVal){
		return this.data=dataVal; 
	}
	public Node<E> getNext(){
		return next; 
	}
	//getters and setters END
	
	public String toString(){
		String output = ""; 
		return output + this.data; 
	}}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E> {
		private Node<E> nextNode; 
		
		public LinkedListIterator(){
			nextNode = head; 
		}
		
		public boolean hasNext(){
			return nextNode != null; 
		}
		
		public E next(){
			if (!hasNext()) throw new NoSuchElementException(); 
			E next = nextNode.data; 
			nextNode = nextNode.next; 
			return next; 
		}
	}
	
}
