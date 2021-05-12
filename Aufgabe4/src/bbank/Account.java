package bbank;


public final class Account { //implements Serializable
	private String number;
	private double amount;

	public Account(String number, double amount) {
		this.number = number;
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Account [number=" + number + ", amount=" + amount + "]";
	}
}
