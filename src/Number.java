/** CheckWriter Class */

/** EDIT HISTORY
 * 2/17/17: Class created
 * 2/18/17: Class tested - minor changes made to delete redundant code
 */


import java.text.NumberFormat;

public class Number {
	
	private double originalNumber;
	private String formattedNumber;
	private String numberAsWords;
	private String fullCheck;
	
	private String [] numbersToNineteen = {"Zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", 
			"nine ", "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", 
            "eighteen ", "ninteteen "};

	private String [] tens = {"zero", "ten", "twenty-", "thirty-", "forty-", "fifty-", "sixty-", "seventy-", "eighty-", "ninety-"};
	
	/** Default constructor */
	public Number() {
		originalNumber = 0.00;
		formattedNumber = "0.00";
		numberAsWords = "Zero dollars and zero cents";
		fullCheck = "$" + formattedNumber + "   " + numberAsWords;
	}
	
	/** Constructor for whole dollar amounts */
	public Number(int dollars) {
		originalNumber = dollars;
		formattedNumber = convertToFormatted(dollars);
		numberAsWords = convertDollarsToWords(dollars) + " dollars and zero cents";
		fullCheck = "$" + formattedNumber + "   " + numberAsWords;
	}
	
	/** Constructor for amounts with dollars and cents */
	public Number(int dollars, int cents) {
		originalNumber = dollars + cents;
		formattedNumber = convertToFormatted(dollars, cents);
		numberAsWords = convertDollarsToWords(dollars) + " dollars and " + convertCentsToWords(cents) + " cents";
		fullCheck = "$" + formattedNumber + "   " + numberAsWords;
	}
	
	/** Convert input number (whole dollar amount only) to a formatted number with commas) */
	private String convertToFormatted(int number) {
		return NumberFormat.getIntegerInstance().format(number);
	}
	
	/** Convert input number (with both dollars and cents) to a formatted number with commas) */
	private String convertToFormatted(int dollars, int cents) {
		String tempDollar = NumberFormat.getIntegerInstance().format(dollars);
		String tempCents;
		if(cents < 10)
			tempCents = "0" + NumberFormat.getInstance().format(cents);
		else
			tempCents = NumberFormat.getInstance().format(cents);
		return tempDollar + "." + tempCents;
	}


	
	/** Convert dollars to words */
	private String convertDollarsToWords(int number) {
		String numberAsWords = "";

		//convert number to six digit char array
		String temp = Integer.toString(number);
		char [] tempNumberChar = temp.toCharArray();
		char [] numberChar = {'0', '0', '0', '0', '0', '0'};
		
		int j = 5;
		
		for(int i = tempNumberChar.length - 1; i >= 0; i--){
			numberChar[j] = tempNumberChar[i];
			j--;
		}
		
		//extract each digit as an individual int
		int firstDigit = Character.getNumericValue(numberChar[0]);
		int secondDigit = Character.getNumericValue(numberChar[1]);
		int thirdDigit = Character.getNumericValue(numberChar[2]);
		int fourthDigit = Character.getNumericValue(numberChar[3]);
		int fifthDigit = Character.getNumericValue(numberChar[4]);
		int sixthDigit = Character.getNumericValue(numberChar[5]);
				
		//convert the first half of the six-digit number to words
		if(secondDigit < 2)
			numberAsWords = numbersToNineteen[firstDigit] + "hundred " + numbersToNineteen[(secondDigit * 10) + thirdDigit] + "thousand ";
		else
			numberAsWords = numbersToNineteen[firstDigit] + "hundred " + tens[secondDigit] + numbersToNineteen[thirdDigit] + "thousand ";
			
		//convert the second half of the six-digit number to words
		if(fifthDigit < 2)
			numberAsWords = numberAsWords + numbersToNineteen[fourthDigit] + "hundred " + numbersToNineteen[(fifthDigit * 10) + sixthDigit];
		else
			numberAsWords = numberAsWords + numbersToNineteen[fourthDigit] + "hundred " + tens[fifthDigit] + numbersToNineteen[sixthDigit];
				
		//format the String - remove extra words and spaces, then capitalize the first letter
		numberAsWords = removeExtraWordsAndSpaces(numberAsWords);
		numberAsWords = numberAsWords.substring(0, 1).toUpperCase() + numberAsWords.substring(1);
		
		return numberAsWords;
	}
	

	
	/** Convert cents to words */
	private String convertCentsToWords(int cents) {
		String numberAsWords = "";
		
		//convert the first half of the six-digit number to words
		if(cents < 20)
			numberAsWords = numbersToNineteen[cents];
		else
			numberAsWords = tens[cents / 10] + numbersToNineteen[cents % 10];
		
		//format the String - remove extra words and spaces
		numberAsWords = removeExtraWordsAndSpaces(numberAsWords);
		
		return numberAsWords;
	}
	
	/** Format dollar and cents as words to remove extra words and spaces */
	private String removeExtraWordsAndSpaces(String phrase) {
		phrase = phrase.replaceAll("-zero", "");
		phrase = phrase.replaceAll("-Zero", "");
		phrase = phrase.replaceAll("zero hundred", "");
		phrase = phrase.replaceAll("Zero hundred", "");
		phrase = phrase.replaceAll("zero thousand", "");
		phrase = phrase.replaceAll("Zero thousand", "");

		phrase = phrase.replaceAll("zero", "");
		phrase = phrase.replaceAll("   ", "").replaceAll("  ", "");
		phrase = phrase.trim();
		
		return phrase;
	}

	public double getOriginalNumber() {
		return originalNumber;
	}

	public void setOriginalNumber(double originalNumber) {
		this.originalNumber = originalNumber;
	}

	public String getFormattedNumber() {
		return formattedNumber;
	}

	public void setFormattedNumber(String formattedNumber) {
		this.formattedNumber = formattedNumber;
	}

	public String getNumberAsWords() {
		return numberAsWords;
	}

	public void setNumberAsWords(String numberAsWords) {
		this.numberAsWords = numberAsWords;
	}

	public String getFullCheck() {
		return fullCheck;
	}

	public void setFullCheck(String fullCheck) {
		this.fullCheck = fullCheck;
	}
	
}
