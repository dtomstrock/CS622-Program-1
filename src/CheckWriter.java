/** CheckWriter Class */

/** EDIT HISTORY
 * 2/17/17: Class created
 * 2/18/17: Class tested - minor changes made to delete redundant code
 */

import java.util.Scanner;

public class CheckWriter {

	public static void main(String[] args) {
		
		String inputNumber;
		Number n1 = new Number();

		System.out.println("Enter the amount of the check you wish to write: ");

		Scanner keyboard = new Scanner(System.in);
		inputNumber = keyboard.nextLine();
		
		String dollarAmountStr = "";
		int dollarAmount = 0;
		String centsAmountStr = "";
		int centsAmount = 0;
		
		//extract substring of dollars and convert to int
		//extract substring of cents and convert to int
		//if dollar amount is not positive or cents amount exceeds 99, ask user to try again
		//exit program if user has three unsuccessful attempts
		int inputAttempts = 0;
		do {
			if(inputAttempts == 3) {
				System.out.println("Too many unsuccessful attempts. Program terminated.");
				System.exit(0);
			}
			
			if(inputAttempts > 0) {
				System.out.println("You must enter a valid number.");
				System.out.println("Try again: ");
				inputNumber = keyboard.nextLine();
			}
			
			if(inputNumber.contains(".")) {
				dollarAmountStr = inputNumber.substring(0, inputNumber.indexOf('.'));
				dollarAmount = Integer.parseInt(dollarAmountStr);
				centsAmountStr = inputNumber.substring(inputNumber.indexOf(".") + 1);
				if(centsAmountStr.length() == 1)
					centsAmount = Integer.parseInt(centsAmountStr) * 10;
				else
					centsAmount = Integer.parseInt(centsAmountStr);
			}
			else {
				dollarAmount = Integer.parseInt(inputNumber);
			}
			
			inputAttempts++;
		} while(dollarAmount < 0 || centsAmount > 99 || dollarAmount > 999999 || (dollarAmount == 0 && centsAmount == 0));
		
		keyboard.close();
		
		if(centsAmount > 0)
			n1 = new Number(dollarAmount, centsAmount);
		else
			n1 = new Number(dollarAmount);
		
		System.out.println(n1.getFullCheck());
		
	}
	
}
