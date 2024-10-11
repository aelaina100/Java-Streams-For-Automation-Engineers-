package Inhertitance;

public class grandSon extends son {
// Note: Java does not support multiple inhertitance (Ex:'grandSon' class can only extend the 'son'one and no other additional class)
	public static void main(String[] args) {
		grandSon gs= new grandSon();
		
		gs.activities();
		gs.city();
		gs.country();
		System.out.println(gs.z);

	}

}
