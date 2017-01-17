import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class NumberUtils {
	public static String toEnglish(BigInteger number) {
		String numberStr = number.toString();
		StringBuilder result = new StringBuilder("");
		
		if (new BigInteger("20").compareTo(number) > 0) {
			return basicNumbersToEnglish(number);
		} else if (numberStr.length() == 2) {
			if (numberStr.startsWith("2")) {
				result.append("twenty");
			} else if (numberStr.startsWith("3")) {
				result.append("thirty");
			} else if (numberStr.startsWith("4")) {
				result.append("forty");
			} else if (numberStr.startsWith("5")) {
				result.append("fifty");
			} else if (numberStr.startsWith("6")) {
				result.append("sixty");
			} else if (numberStr.startsWith("7")) {
				result.append("seventy");
			} else if (numberStr.startsWith("8")) {
				result.append("eighty");
			} else if (numberStr.startsWith("9")) {
				result.append("ninety");
			}
		}
		if (!numberStr.endsWith("0")) {
			result.append("-").append(basicNumbersToEnglish(number.subtract(new BigInteger(numberStr.charAt(0) + "0"))));
		}
		return result.toString();
	}

	private static String basicNumbersToEnglish(BigInteger number) {
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
		} else {
			return "nineteen";
		}
	}
}