package club.makeable.apcs;
import java.util.*;

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
		Account bankAcct = new BankAccount("B123", "super$ecret");
		bankAcct.setName("Chase Bank");
		double money = 105.60;
		bankAcct.setBalance(money);
		((BankAccount)bankAcct).getInterestPayment();
		
		
		Comparable bAcct = new BankAccount("", "");
		
		List<Comparable> list = new ArrayList<Comparable>();
		list.add(bankAcct);
		list.add(bAcct);
		
		// Account acct = new Account();
		
		System.out.println("Bank account has balance: $" + bankAcct.getBalance());
		
		Account stockAcct = new StockAccount();	//TODO: why this constructor work?
		stockAcct.setName("Raymond's Stock Account");
		System.out.println("Stock account has balance: $" + stockAcct.getBalance());		
		double b = stockAcct.getBalance();
		
		Account.getRicherAccount(bankAcct, stockAcct);
		
		//TODO: example for downcasting in actual method!
		// checkInterestIncome(bankAcct);
		// checkInterestIncome(stockAcct);
		
		bankAcct.transfer("super$ecret", 10.0f, bankAcct, stockAcct);
		
	}

}
