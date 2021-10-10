
import java.util.Scanner;
import java.util.ArrayList; //Dynamic length array class

public class StackAndQueue{
	
	
	  public static void main(String[] args) { 
		  Scanner s = new Scanner(System.in);
		  //Get input as input format.
		  String nAndm = s.nextLine(); //Get the stack size N and pick up elements size K
		  String stack = s.nextLine(); //Get the stack from input
		  s.close();
		  //Trun data type from string to int
		  //It should put a try...catch to get wrong data type exception
		  int N = Integer.parseInt(nAndm.split(" ")[0]);
		  int K = Integer.parseInt(nAndm.split(" ")[1]);
		  //Make the pickup elements number reasonable
		  if (K >= N) {
			  System.out.println("The pickup number should be less than the array size\n");
			  return;
		  }
		  //Turn input stream to array
		  //It should put a try...catch to get wrong data type exception
		  String[] strNarr = stack.split(" ");
		  int[] possiblesum = new int[K]; //declare a array to store possible value on each situation.
		  //Total K possible situation, pop elements out between 1 and K times. 
		  for(int i = 0; i < K; i++) {
			  int popsum = 0; //Poped elements sum.
			  int stacksum = 0; //The rest elements in stack sum
			  int[] arrN = new int[N];
			  
			  for(int j = 0; j <= i; j++) {
				  popsum = popsum + Integer.parseInt(strNarr[j]); //Get sum of pop elements
			  }
			  //System.out.println(popsum);
			  
			  for(int n = 0; n < N - i - 1; n++) {
				  //Load the String array to integer array
				  //Convert the rest elements except pop elements
				  arrN[n]=Integer.parseInt(strNarr[N - n - 1]); 
			  }
			  for(int m = 0; m < K - i - 1; m++) {
				  stacksum = stacksum + arrN[m]; //Get sum of elements which are K - poped elements
			  }
			  //System.out.println(stacksum);
			  
			  possiblesum[i] = popsum + stacksum;
			  
		  }
		  
		  int max = 0;
		  //Find the max value from the possible arrary
		  for (int i = 0; i < possiblesum.length; i++) {
			  //System.out.println(possiblesum[i]);
			  if (max < possiblesum[i]) {
				  max = possiblesum[i];
			  }
		  }
		  System.out.println(max);
	  }
		/*Scanner s = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>(); //declare Arraylist by data types
		System.out.println("Input any integer number, Type 000 to save and exit");
		while (true) {
			int inputnumber = s.nextInt(); //should add a verify or try....catch exception
			if (inputnumber == 000)
				break;
			else
				arr.add(inputnumber);
		}
		s.close();*/
}
