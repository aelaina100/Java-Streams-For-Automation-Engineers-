package JavaPkg;

/* Create the array     1 2 11 7
                        3 4 12 8
                        5 6 13 9       and display its numbers */   

public class I_Multi_dim_arrays {

	public static void main(String[] args) {
		int y[][]= new int [3][4];
		y[0][0]= 1;
		y[0][1]= 2;
		y[0][2]= 11;
		y[0][3]= 7;
		y[1][0]= 3;
		y[1][1]= 4;
		y[1][2]= 12;
		y[1][3]= 8;
		y[2][0]= 5;
		y[2][1]= 6;
		y[2][2]= 13;
		y[2][3]= 9;   
 //int y[][]= {{1,2,11,7},{3,4,12,8},{5,6,13,9}};  // is the common sence way.
		
		
// Display these numbers
	for ( int i=0; i<3; i++)   // i=0  i=1  i=2
	{
		for (int j=0; j<4; j++ )   // j=0   j=1  j=2  j=4
		{
			System.out.println(y[i][j]);
	    }		
	}
	// display 9
		System.out.println("");
		System.out.println(y[2][3]);
	}

}
