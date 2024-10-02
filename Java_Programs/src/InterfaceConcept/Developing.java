package InterfaceConcept;

public class Developing implements BankingClient, DomainClient{ // could've as many interfaces as wished.
	
	

	public static void main(String[] args) {
		
		Developing d= new Developing(); // Accesses all method(s) & variable(s) in: BankingClient, DomainClient, & Developing class.
		d.checkingBalance();
		d.payCreditCard();
		d.transferBalance();
		d.login();
		d.investment();
		
		BankingClient bc= new Developing(); // Accesses all method(s) & variable(s) in BankingClient ONLY
		bc.checkingBalance();
		bc.payCreditCard();
		bc.transferBalance();
		
		
		DomainClient dc= new Developing();  // Accesses all method(s) & variable(s) in DomainClient ONLY
		dc.investment();	
		

	}

	@Override
	public void payCreditCard() {
		
		
	}

	@Override
	public void transferBalance() {
		
		
	}

	@Override
	public void checkingBalance() {
		
		
	}

	@Override
	public void investment() {
		// TODO Auto-generated method stub
		
	}
	
	public void login()  // typed/added 
	{
		
	}


	}


