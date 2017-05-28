
public class Person {
	

	public String firstName, lastName;
	public double amountOfMoney;
	private Validator _vlidator;
	private Number _num;
	public Person() {
		firstName = "first";
		lastName = "last";
		amountOfMoney = 5000.00;
		_vlidator = new Validator(amountOfMoney);
		_num= new Number();
	}
	
	public String StringTobeWrittenOnCheck(double argAmunt){
		if (_vlidator.validate(argAmunt)){
			return _num.DoFullConversion(argAmunt);	
		}
		return "not enough money";
	}
	

}
