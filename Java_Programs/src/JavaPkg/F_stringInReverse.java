package JavaPkg;

// print out 'Print me in reverse' in reverse
public class F_stringInReverse {

	public static void main(String[] args) {
		
		String phrase= "Print me in reverse";
		String reversed= "";
		
		for(int i= phrase.length(); i>0 ;i--)  // assume the legth here is 5 so:   i=5  i=4....i=1
		{
		 /* Below works too.
		  * char letter= phrase.charAt(i-1);                                   
		 reversed= reversed+ letter;  	     */
			reversed= reversed + phrase.charAt(i-1);
		}
		System.out.println(reversed);
	}

}
//(As soon as complier reads: "phrase.charAt(",It automatically assigns index values to each character making up the 
// value of 'phrase', from 0 to max. Now you're asking for CharAt(max plus 1) which can not be found/ out of bound by a notch
//since argument comes from i=phrase.length()