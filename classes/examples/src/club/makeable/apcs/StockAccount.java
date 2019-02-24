package club.makeable.apcs;

public class StockAccount extends Account {
	private double shares;	// TODO: getters and setters
	private double prices;
	
	
	
	@Override
	public double getBalance() {
		if( super.getBalance() >= 0.01f) {	// if it has at least 1 cent
			return super.getBalance();
		}
		
		return shares * prices;
	}
	
	@Override
	protected int getType() {
		return Account.TYPE_STOCK;
	}

}
