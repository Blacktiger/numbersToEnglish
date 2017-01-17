import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class NumberUtils {
	private static final BigInteger ONE_HUNDRED = new BigInteger("100");

	public static String toEnglish(BigInteger number) {
		if (BigInteger.ZERO.equals(number)) {
			return "zero";
		}

		String reversedNumber = StringUtils.reverse(number.toString());
		List<String> reversedComponents = StringUtils.splitBySize(reversedNumber);
		List<String> numberComponents = reversedComponents.stream().map(StringUtils::reverse).collect(Collectors.toList());

		StringBuilder builder = new StringBuilder();
		for (int i = numberComponents.size() - 1; i >= 0; i--) {
			BigInteger componentNumber = new BigInteger(numberComponents.get(i));
			String componentResult = hundredsToEnglish(componentNumber);
			builder.append(componentResult);
			if (!BigInteger.ZERO.equals(componentNumber)) {
				if (i == 1) {
					builder.append(" thousand ");
				} else if (i == 2) {
					builder.append(" million ");
				} else if (i == 3) {
					builder.append(" billion ");
				} else if (i == 4) {
					builder.append(" trillion ");
				} else if (i == 5) {
					builder.append(" quadrillion ");
				} else if (i == 6) {
					builder.append(" quintillion ");
				} else if (i == 7) {
					builder.append(" sextillion ");
				}
			}
		}

		StringUtils.trimTrailingSpace(builder);

		return builder.toString();
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

	private static String hundredsToEnglish(BigInteger number) {
		if (BigInteger.ZERO.equals(number)) {
			return "";
		}

		BigInteger hundreds = number.divide(ONE_HUNDRED);
		BigInteger tens = number.mod(ONE_HUNDRED).divide(BigInteger.TEN);
		BigInteger ones = number.mod(ONE_HUNDRED).mod(BigInteger.TEN);

		StringBuilder builder = new StringBuilder("");
		if (hundreds.compareTo(BigInteger.ZERO) > 0) {
			builder.append(onesToEnglish(hundreds)).append(" hundred ");
		}

		if (isTen(tens)) {
			builder.append(teensToEnglish(number));
		} else if (isTens(tens)) {
			builder.append(tensToEnglish(tens, ones));
		} else {
			builder.append(onesToEnglish(ones));
		}

		StringUtils.trimTrailingSpace(builder);

		return builder.toString();
	}
}