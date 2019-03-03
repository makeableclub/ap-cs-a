package club.makeable.apcs;

public class BankAccount extends Account
{
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

	/**
	 * Get expected payment with interest payout
	 * 
	 * @return
	 */
	public double getBalanceWithInterest() {
		double balance = super.getBalance() * (1+interestRate);
		return balance;
	}

	
	/**
	 * calculate bank account interest payment
	 * 
	 * @return
	 */
	public double getInterestPayment() {
		double amount = getBalance() * interestRate;
		
		return amount;
	}

}
