import java.util.Arrays;
import java.util.List;

public class StringUtils {
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static List<String> splitBySize(String str, int size) {
		return Arrays.asList(str.split("(?<=\\G.{" + size + "})"));
	}

	public static void trimTrailingSpace(StringBuilder builder) {
		if (builder.charAt(builder.length() - 1) == ' ') {
			builder.setLength(builder.length() - 1);
		}
	}
}