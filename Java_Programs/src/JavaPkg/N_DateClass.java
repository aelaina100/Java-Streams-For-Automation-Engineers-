package JavaPkg;
import java.text.SimpleDateFormat;
import java.util.Date;  //Important: Util package "jave.util" contains the date class & the 'collections' framework.

public class N_DateClass {

	public static void main(String[] args) {
		// I want to to display today's date in the format of mm/dd/yyyy
		
		
		Date d= new Date(); // contains current date, in and by itself.
		System.out.println(d.toString());  // output is:    Sat Feb 11 19:39:26 EST 2023   so to format:
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(d));
        
        
	}

}
