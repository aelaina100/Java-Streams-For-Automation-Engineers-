package JavaPkg;
//From the below matrix, for the minimum number, print out the maximum number of its associated column 
/*  2 4 5
    3 4 7
    1 2 9
*/
	//Plan: find out the min number in this matrix.
    	// Find out its associated column.
public class M_column_of_min {
	public static void main(String [] args) {
		
		int matrix[][]= {{2,-4,5},{3,4,7},{1,2,9}};
		int column_index = 0;
		int minimum= matrix[0][0];
		int maximum_InColumn=0;
		for(int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if(matrix[i][j] < minimum)
						{
					minimum= matrix[i][j];
					 column_index=  j;
					}}}		
		// Traverse throughout that column
		for(int l=0; l<3   ;l++)  // I harcoded '3'. How to undo that ?
		{
			if(minimum <matrix[l][column_index]);
			{
				 maximum_InColumn= matrix[l][column_index];}
		}
		System.out.println("For the min number in matrix, its assoicated column has the max number of: "+maximum_InColumn );
	}}
		
	


