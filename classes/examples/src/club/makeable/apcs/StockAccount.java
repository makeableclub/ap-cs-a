package club.makeable.apcs;

public class StockAccount extends Account {
	private double shares;	// TODO: getters and setters
	private double prices;
	
	@Override
	public double getBalance() {
		return shares * prices;
	}
	
	@Override
	protected int getType() {
		return Account.TYPE_STOCK;
	}
	
	/**
	 * Add fund to stock account, convert money to stock shares
	 * 
	 * @param pass	The password to be matched with account
	 * @param amount The amount to be added to the account
	 */
	public void deposit(String pass, double amount) {
		if(pass!=null && pass.equals(getPassword())) {
			shares = shares + amount / prices;
		}
	}
	
	/**
	 * Withdraw money from account, by selling shares
	 * 
	 * @param pass	The password to be matched with account
	 * @param amount The amount to be withdrew
	 * @return	a boolean: true to indicate successfully withdraw, 
	 * 					   false to indicate failed to withdraw due to insufficient amount 
	 * 					   or mismatched password.
	 */
	public boolean withdraw(String pass, double amount) {
		// check password to match
		if(pass!=null && pass.equals(getPassword())) 
		{
			double totalValue = shares * prices;
			
			// check sufficient fund
			if( totalValue > amount ) {
				shares = shares - amount/prices;
				return true;
			}
		}

		return false;
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
