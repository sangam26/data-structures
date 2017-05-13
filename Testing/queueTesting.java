package linear;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

public class queueTesting {
	queueArray<Integer> queue = new queueArray<Integer>();
	queueLinkedList<Integer> queueList = new queueLinkedList<Integer>(); 
	
	@Before public void setup(){
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		queueList.enqueue(1);
		queueList.enqueue(2);
		queueList.enqueue(3);
		queueList.enqueue(4);
		queueList.enqueue(5);
		
	}
	 @Test 
	 public void dequeue(){
		 queue.enqueue(6);
		 assertEquals(1, (int) queue.dequeue());
		 queue.dequeue(); 
		 assertEquals(3, (int) queue.dequeue());
	 }
	 
	 @Test
	 public void clear(){
		 queue.clear();
		 assertEquals(true, queue.isEmpty());
	 }
	 
	 @Test
	 public void dequeueLinkedList(){
		 queueList.enqueue(6);
		 assertEquals(1, (int) queueList.dequeue());
		 queueList.dequeue(); 
		 assertEquals(3, (int) queueList.dequeue());
	 }
	 
	 @Test
	 public void clearQueueList(){
		 queueList.clear();
		 queueLinkedList<Integer> queueList2 = new queueLinkedList<Integer>();
		 queueList2.enqueue(1);
		 assertEquals(1, (int) queueList2.dequeue());
	 }
		
}
