package linear;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> aList = new LinkedList<String>(); 
		aList.add("a");
		aList.add("b");
		aList.add("c");
		aList.add("d");
		
		
		System.out.println("before reverse");
		for(String temp: aList){
			System.out.println(temp);
		}
		aList.reverse();
		int counter =0; 
		System.out.println("after reverse");
		for(String temp: aList){
			System.out.println(temp);
		}
		System.out.println("first element is "+aList.get(0));

	}

}
