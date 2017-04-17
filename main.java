package linear;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis(); 
		LinkedList<String> aList = new LinkedList<String>(); 
		LinkedList<String> aList2; 
		aList.add("a");
		aList.add("b");
		aList.add("b");
		aList.add("b");
		aList.add("a");
		
		
		//System.out.println(aList.isPalindromeWithoutBuffer());
		//System.out.println(aList.isPalindrome());
		
		//aList.isPalindromeWithoutBuffer();  
		long endTime   = System.currentTimeMillis(); 
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		

	}

}
