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
		this.balance = balance;
	}

	/**
	 * Get account type, such as Bank or Stock account
	 * 
	 * @return	an integer to represent the account type
	 */
	protected abstract int getType();	// TODO: Abstract method to be implemented by subclass
	
	
	/**
	 * Set the account type
	 * 
	 * @param type the type of account
	 */
//	protected void setType(int type) {
//		this.type = type;
//	}
	
	/**
	 * A static method to demo: 1. how to invoke, 2. object parameters in method call
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
