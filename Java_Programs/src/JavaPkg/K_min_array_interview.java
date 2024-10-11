package JavaPkg;

/*1- Sum up the numbers contained within the following array.
 *     2  4  5                             
 *     3  4 -7
 *     1  2  9      */                                   
                                                                                
//2- print out the number at the index of '3'
//3- print out the index, at which number 5 is at.

public class K_min_array_interview {
	
	public static void main (String[] args)
	{
		int multi[][]= {{2,4,5}, {3,4,-7}, {1,2,9}};  
		int min= multi[0][0]; // Assuming that this is the minimum value
		
		for(int i=0; i<multi.length; i++)
		{
			for(int j=0; j<multi.length; j++)
			{
				if(multi[i][j] <min)
				{
					min= multi[i][j];
				}
			}
		}
		System.out.println("Minimum number is: " + min + " in this multidimensional array");
		
		
		
	}
	}
	
		
		
	


