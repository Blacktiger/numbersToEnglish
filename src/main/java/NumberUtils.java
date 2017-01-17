import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class NumberUtils {
	private static final BigInteger ONE_HUNDRED = new BigInteger("100");

	public static String toEnglish(BigInteger number) {
		StringBuilder result = new StringBuilder("");

		BigInteger hundreds = number.divide(ONE_HUNDRED);
		BigInteger tens = number.mod(ONE_HUNDRED).divide(BigInteger.TEN);
		BigInteger ones = number.mod(ONE_HUNDRED).mod(BigInteger.TEN);

		if (BigInteger.ZERO.equals(number)) {
			return "zero";
		}

		if (hundreds.compareTo(BigInteger.ZERO) > 0) {
			result.append(onesToEnglish(hundreds)).append(" hundred ");
		}

		if (isTen(tens)) {
			result.append(teensToEnglish(number));
		} else if (isTens(tens)) {
			result.append(tensToEnglish(tens, ones));
		} else {
			result.append(onesToEnglish(ones));
		}

		// Remove a trailing space if it exists.
		if (result.charAt(result.length() - 1) == ' ') {
			result.setLength(result.length() - 1);
		}

		return result.toString();
	}

	private static boolean isTen(BigInteger tens) {
		return tens.equals(BigInteger.ONE);
	}

	private static boolean isTens(BigInteger tens) {
		return tens.compareTo(BigInteger.ONE) > 0;
	}

	private static String onesToEnglish(BigInteger number) {
		if (BigInteger.ONE.equals(number)) {
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
		} else {
			return "";
		}
	}

	private static String teensToEnglish(BigInteger number) {
		if (new BigInteger("10").equals(number)) {
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

	private static String tensToEnglish(BigInteger tens, BigInteger ones) {
		StringBuilder result = new StringBuilder();
		if (tens.equals(new BigInteger("2"))) {
			result.append("twenty");
		} else if (tens.equals(new BigInteger("3"))) {
			result.append("thirty");
		} else if (tens.equals(new BigInteger("4"))) {
			result.append("forty");
		} else if (tens.equals(new BigInteger("5"))) {
			result.append("fifty");
		} else if (tens.equals(new BigInteger("6"))) {
			result.append("sixty");
		} else if (tens.equals(new BigInteger("7"))) {
			result.append("seventy");
		} else if (tens.equals(new BigInteger("8"))) {
			result.append("eighty");
		} else if (tens.equals(new BigInteger("9"))) {
			result.append("ninety");
		}

		if (!BigInteger.ZERO.equals(ones)) {
			result.append("-").append(onesToEnglish(ones));
		}

		return result.toString();
	}
}