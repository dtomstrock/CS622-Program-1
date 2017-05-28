
public class Validator {

	private double amountAvailable;
	
	public Validator(){
		amountAvailable = 0;
	}
	
	public Validator(double personsMoney){
		amountAvailable = personsMoney;
	}
	
	public boolean validate(double amount) {
		if(amount <= amountAvailable)
			return true;
		return false;
	}
	
}
