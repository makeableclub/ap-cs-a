package club.makeable.apcs;



public abstract class Account {
	public static final int TYPE_BANK = 1;
	public static final int TYPE_STOCK = 2;
	
	private String id;
	private String password;
	private String name;
	private double balance;
	// private int type;
	
	/**
	 * Default constructor
	 */
	public Account() {
		// nothing
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param acctId	the account id
	 * @param acctPass	the password to the account
	 */
	public Account(String acctId, String acctPass) {
		this.id = acctId;		// you may omit "this"
		password = acctPass;
	}
	
	/**
	 * Retrieve the account password
	 * 
	 * @return a string of the account password
	 */
	protected String getPassword() {
		return password;
	}
	
	/**
	 * Getter method for "name" field
	 * 
	 * @return the name string
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set an alias name for the account
	 * 
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the balance amount of the account
	 * 
	 * @return a double number showing the balance amount
	 */
	protected double getBalance() {
		return balance;
	}


	protected void setBalance(double balance) {
		balance = 4.50;
		this.balance = balance;
	}

	/**
	 * Get account type, such as Bank or Stock account
	 * 
	 * @return	an integer to represent the account type
	 */
	protected abstract int getType();
	// TODO: Abstract method to be implemented by subclass
	
	
	/**
	 * Set the account type
	 * 
	 * @param type the type of account
	 */
//	protected void setType(int type) {
//		this.type = type;
//	}
	
	
	/**
	 * Add money to account
	 * 
	 * @param pass	The password to be matched with account
	 * @param amount The amount to be added to the account
	 */
	public void deposit(String pass, double amount) {
		if(pass!=null && pass.equals(password)) {
			balance += amount;
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
		if(pass!=null && pass.equals(password)) 
		{
			// check sufficient fund
			if( balance > amount ) {
				balance = balance - amount;
				return true;
			}
		}

		return false;
	}
	
	/**
	 * 
	 * @param acct1
	 * @param acct2
	 */
	public boolean transfer(String pass, double amount, Account fromAcct, Account toAcct) {
		if( fromAcct.withdraw(pass, amount) ) {
			toAcct.deposit(pass, amount);
			return true;
		}
		return false;
	}
	
	/**
	 * A static method to demo: 1. how to invoke, 2. object parameters in method call
	 * 
	 * @param acct1
	 * @param acct2
	 * @return
	 */
	public static Account getRicherAccount(Account acct1, Account acct2) {
		if( acct1.getBalance() > acct2.getBalance() ) {
			return acct1;
		}
		return acct2;
	}
}
