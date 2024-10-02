package JavaPkg;


public class testingzzzzz {
	
	public static void main (String[] args)
	{
		int multi[][]= {{2,4,5}, {3,4,-7}, {1,2,9}};  
		
		int sum=0;
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				sum= sum + multi[i][j];
			}
		}
		System.out.println(sum);
   }
}
