package ThisKeyword;
// This is another 'flavour' of the previous class 'A_demo'
// Study it and predict the output

public class B_Demo {
	
	int a= 2;
	
	public void getData()
	{
		int a= 3;
		System.out.println(this.a);
		
		int b;
		b= this.a +a;
		System.out.println(b);
	}
	
	

	public static void main(String[] args) {
		
		B_Demo ob= new B_Demo();
		ob.getData();
		

	}

}
