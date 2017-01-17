import java.math.BigInteger;

class NumberUtils {
	public static String toEnglish(BigInteger number) {
		if (BigInteger.ZERO.equals(number)) {
			return "zero";
		} else if (BigInteger.ONE.equals(number)) {
			return "one";
		} else if (new BigInteger("2").equals(number)) {
			return "two";
		} else if (new BigInteger("3").equals(number)) {
			return "three";
		} else if (new BigInteger("4").equals(number)) {
			return "four";
		} else if (new BigInteger("5").equals(number)) {
			return "five";
		} else if (new BigInteger("6").equals(number)) {
			return "six";
		} else if (new BigInteger("7").equals(number)) {
			return "seven";
		} else if (new BigInteger("8").equals(number)) {
			return "eight";
		} else if (new BigInteger("9").equals(number)) {
			return "nine";
		} else if (new BigInteger("10").equals(number)) {
			return "ten";
		} else if (new BigInteger("11").equals(number)) {
			return "eleven";
		} else if (new BigInteger("12").equals(number)) {
			return "twelve";
		} else if (new BigInteger("13").equals(number)) {
			return "thirteen";
		} else if (new BigInteger("14").equals(number)) {
			return "fourteen";
		} else if (new BigInteger("15").equals(number)) {
			return "fifteen";
		} else if (new BigInteger("16").equals(number)) {
			return "sixteen";
		} else if (new BigInteger("17").equals(number)) {
			return "seventeen";
		} else if (new BigInteger("18").equals(number)) {
			return "eighteen";
		} else if (new BigInteger("19").equals(number)) {
			return "nineteen";
		} else {
			return "unknown number";
		}
	}
}