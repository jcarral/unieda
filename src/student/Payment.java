package student;

public class Payment {

	private final String payer;
	private final int amount;
	private final String winner;
	
	
	public Payment(String payer, int amount, String winner) {
		super();
		this.payer = payer;
		this.amount = amount;
		this.winner = winner;
	}

	public String getPayer() {
		return payer;
	}
	
	public int getAmount() {
		return amount;
	}
	public String getWinner() {
		return winner;
	}
	
	@Override
	public String toString() {
		return "Payment [payer=" + payer + ", amount=" + amount + ", winner=" + winner + "]";
	}
	
	
}
