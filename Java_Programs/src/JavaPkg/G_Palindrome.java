 package JavaPkg;
// check if 'Salon' is a palindrome

public class G_Palindrome {
	public static void main (String[] args)
	{
		String word= "Sos";
		String reversed= "";
		for (int i= word.length(); i>0; i--)
		{
			char letter= word.charAt(i-1);
	    	reversed=reversed + letter;				
		}
		//System.out.println(reversed);
		if(! word.equalsIgnoreCase(reversed))
		{
			System.out.println(word+ " Is NOT a palindrome. As it's reverse is: "+ reversed);
		}
		else
		{
			System.out.println(word+ " Is a palindrome. As it's reverse is: "+ reversed );
		}

} 
	}


