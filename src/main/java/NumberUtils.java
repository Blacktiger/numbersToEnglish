import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class NumberUtils {
	private static final BigInteger ONE_HUNDRED = new BigInteger("100");
	private static final List<String> ONES = Arrays.asList("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
	private static final List<String> TEENS = Arrays.asList("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
	private static final List<String> TENS = Arrays.asList("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");
	private static final List<String> SCALES = Arrays.asList("", " thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ");


	public static String toEnglish(BigInteger number) {
		if (BigInteger.ZERO.equals(number)) {
			return "zero";
		}

		StringBuilder builder = new StringBuilder();
		if (number.compareTo(BigInteger.ZERO) < 0) {
			builder.append("negative ");
		}

		number = number.abs();

		String reversedNumber = StringUtils.reverse(number.toString());
		List<String> reversedComponents = StringUtils.splitBySize(reversedNumber, 3);
		List<String> numberComponents = reversedComponents.stream().map(StringUtils::reverse).collect(Collectors.toList());

		for (int i = numberComponents.size() - 1; i >= 0; i--) {
			BigInteger componentNumber = new BigInteger(numberComponents.get(i));
			String componentResult = hundredsToEnglish(componentNumber);
			builder.append(componentResult);
			if (!BigInteger.ZERO.equals(componentNumber)) {
				builder.append(SCALES.get(i));
			}
		}

		StringUtils.trimTrailingSpace(builder);

		return builder.toString();
	}

	private static String hundredsToEnglish(BigInteger number) {
		if (BigInteger.ZERO.equals(number)) {
			return "";
		}

		BigInteger hundreds = number.divide(ONE_HUNDRED);
		BigInteger tens = number.mod(ONE_HUNDRED).divide(BigInteger.TEN);
		BigInteger ones = number.mod(ONE_HUNDRED).mod(BigInteger.TEN);

		StringBuilder builder = new StringBuilder("");
		if (isHundreds(hundreds)) {
			builder.append(onesToEnglish(hundreds)).append(" hundred ");
		}

		if (isTen(tens)) {
			builder.append(teensToEnglish(number.subtract(ONE_HUNDRED.multiply(hundreds))));
		} else if (isTens(tens)) {
			builder.append(tensToEnglish(tens, ones));
		} else {
			builder.append(onesToEnglish(ones));
		}

		StringUtils.trimTrailingSpace(builder);

		return builder.toString();
	}

	private static boolean isHundreds(BigInteger hundreds) {
		return hundreds.compareTo(BigInteger.ZERO) > 0;
	}

	private static boolean isTen(BigInteger tens) {
		return tens.equals(BigInteger.ONE);
	}

	private static boolean isTens(BigInteger tens) {
		return tens.compareTo(BigInteger.ONE) > 0;
	}

	private static String tensToEnglish(BigInteger tens, BigInteger ones) {
		StringBuilder result = new StringBuilder();
		result.append(TENS.get(tens.intValue()));

		if (!BigInteger.ZERO.equals(ones)) {
			result.append("-").append(onesToEnglish(ones));
		}

		return result.toString();
	}

	private static String teensToEnglish(BigInteger number) {
		return TEENS.get(number.intValue() - 10);
	}

	private static String onesToEnglish(BigInteger ones) {
		return ONES.get(ones.intValue());
	}
}