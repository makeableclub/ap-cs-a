package club.makeable.apcs;

public class TestDriver {

	//TODO: talking point: use static vs instance method
	static void checkInterestIncome(Account acct)
	{
		// Downcasting example!
		double interestMoney = ((BankAccount)acct).getInterestPayment();
		//TODO: why "(BankAccount)acct.getInterestPayment()" fail?
		
		System.out.println("Interest Income: " + interestMoney);
	}
	
	// this static "main" method makes "TestDriver" class to become an application
	// and this method is the entry point when application runs
	//
	public static void main(String[] args) {
		// BankAccount bankAcct = new BankAccount();	//TODO: why doesn't work?
		BankAccount bankAcct = new BankAccount("B123", "super$ecret");
		bankAcct.setName("Chase Bank");
		double money = 5.60;
		bankAcct.setBalance(money);
		
		System.out.println("Bank account has balance: $" + bankAcct.getBalance());
		
		StockAccount stockAcct = new StockAccount();	//TODO: why this constructor work?
		stockAcct.setName("Raymond's Stock Account");
		System.out.println("Stock account has balance: $" + stockAcct.getBalance());		
		
		Account.getRicherAccount(bankAcct, stockAcct);
		
		//TODO: example for downcasting in actual method!
		// checkInterestIncome(bankAcct);
		// checkInterestIncome(stockAcct);
		
	}

}
