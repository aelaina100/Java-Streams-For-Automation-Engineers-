package JavaPkg;

public class S_Break_ForLoops {

	public static void main(String[] args) {
		
		int numbers[]= {1,21,51,73,69,81,9,11,1443};
		//Now, Ensure this array has at least one number that is divisible by 2 & display such number.
		for(int i=0; i<numbers.length; i++)
		{
			if(numbers[i]%2==0)
			{
				System.out.println(numbers[i]);
				break;   //exists our for-loop
			}
			
			else if(i==numbers.length-1) {
				System.out.println("No number in the array is divisible by 2");
			}
	    }
  }}
