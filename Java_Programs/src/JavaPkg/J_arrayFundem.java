package JavaPkg;
// 1- Sum up the numbers contained within the following array.
// 2- print out the number at the index of '3'
// 3- print out the index, at which number 5 is at

public class J_arrayFundem {

	public static void main(String[] args) {
		
		int a[]= {1,3,5,7};
		int sum=0;
		int length_array= a.length;
		
		for(int i=0; i<length_array; i++) 
		{
			sum=sum+a[i];

		}
//1-
  System.out.println(" The sum of the array is: " +sum);
//2-
  System.out.println(" In the array, number '5' is at the index of: " + a[3]     );
//3-
  for(int i=0; i<length_array; i++) 
	{
		int x= a[i];
		if(x==5)
		{
			System.out.println(x +" is at the index of: " +i );
			break;
		}

	}






	}
}