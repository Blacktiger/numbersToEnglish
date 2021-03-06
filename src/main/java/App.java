import java.math.BigInteger;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
	public static void main(String[] args) {
		if (args.length == 1) {
			try {
				BigInteger number = new BigInteger(args[0]);
				System.out.println("Input: " + number);
				System.out.println("Output: " + NumberUtils.toEnglish(number));
			} catch (NumberFormatException e) {
				System.out.println(args[0] + " is in an invalid format; please use only numbers - non numeric characters will not be accepted");
			}
		} else {
			System.out.println("You must pass a number");
		}
	}
}
