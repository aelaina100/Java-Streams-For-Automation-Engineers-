package JavaPkg;

public class R_Multiples_of_aNumber {
	
	public static void main(String [] args)
	{
		int numbers[]= {1,2,5,7,6,8,9,11,144};
		//Now, print out numbers that are divisible by 2 (They should be: 2,6,8,122)
		for(int i=0; i<numbers.length; i++)
		{
			if(numbers[i]%2==0)
			{
				System.out.println(numbers[i]);
			}
			
			/*
			else // optional
			{
				System.out.println(numbers[i] + " Is NOT multiple of 2");
			}
			*/
			
		}
		
	}

}
