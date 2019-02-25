package club.makeable.apcs;

public class BankAccount extends Account {
	private double interestRate;	// TODO: make it static?

	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param pass
	 */
	public BankAccount(String id, String pass) {
		super(id, pass);
		
		// setType(Account.TYPE_BANK);
		// do something more
	}
	
	/**
	 * Get the type of account
	 */
	@Override
	public int getType() {	// TODO: switch the visibility marker "public ~ protected"
		return Account.TYPE_BANK;
	}

	@Override
	public double getBalance() {
		double balance = super.getBalance() * (1+interestRate);
		return balance;
	}

	/**
	 * Add money to account
	 * 
	 * @param pass	The password to be matched with account
	 * @param amount The amount to be added to the account
	 */
	public void deposit(String pass, double amount) {
		if(pass!=null && pass.equals(getPassword())) {
			double newAmount = getBalance() + amount;
			setBalance(newAmount);
		}
	}
	
	/**
	 * Withdraw money from account
	 * 
	 * @param pass	The password to be matched with account
	 * @param amount The amount to be withdrew
	 * @return	a boolean: true to indicate successfully withdraw, 
	 * 					   false to indicate failed to withdraw due to insufficient amount 
	 * 					   or mismatched password.
	 */
	public boolean withdraw(String pass, double amount) {
		// check password to match
		if(pass!=null && pass.equals(getPassword())) {
			double currAmount = super.getBalance();
			
			// check sufficient fund
			if( currAmount > amount ) {
				super.setBalance(currAmount-amount);
				return true;
			}
		}

		return false;
	}
}
