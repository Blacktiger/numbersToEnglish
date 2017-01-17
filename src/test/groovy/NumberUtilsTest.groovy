import spock.lang.Specification

class NumberUtilsTest extends Specification {
	def "ones to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		0      | "zero"
		1      | "one"
		2      | "two"
		3      | "three"
		4      | "four"
		5      | "five"
		6      | "six"
		7      | "seven"
		8      | "eight"
		9      | "nine"
	}

	def "teens to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		10     | "ten"
		11     | "eleven"
		12     | "twelve"
		13     | "thirteen"
		14     | "fourteen"
		15     | "fifteen"
		16     | "sixteen"
		17     | "seventeen"
		18     | "eighteen"
		19     | "nineteen"
	}

	def "tens to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		20     | "twenty"
		30     | "thirty"
		40     | "forty"
		50     | "fifty"
		60     | "sixty"
		70     | "seventy"
		80     | "eighty"
		90     | "ninety"
		21     | "twenty-one"
		43     | "forty-three"
		99     | "ninety-nine"
	}

	def "hundreds to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		001    | "one"
		100    | "one hundred"
		113    | "one hundred thirteen"
		200    | "two hundred"
		300    | "three hundred"
		400    | "four hundred"
		500    | "five hundred"
		600    | "six hundred"
		700    | "seven hundred"
		800    | "eight hundred"
		900    | "nine hundred"
		101    | "one hundred one"
		999    | "nine hundred ninety-nine"
	}

	def "thousands to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		1000   | "one thousand"
		9000   | "nine thousand"
		9999   | "nine thousand nine hundred ninety-nine"
	}

	def "large numbers to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number                   | english
		1000000                  | "one million"
		1000000000               | "one billion"
		1000000000000            | "one trillion"
		1000000000000000         | "one quadrillion"
		1000000000000000000      | "one quintillion"
		1000000000000000000000   | "one sextillion"
		999999999999999999999999 | "nine hundred ninety-nine sextillion nine hundred ninety-nine quintillion nine hundred ninety-nine quadrillion nine hundred ninety-nine trillion nine hundred ninety-nine billion nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine"
	}

	def "negative numbers to english"() {
		expect:
		NumberUtils.toEnglish(number) == english

		where:
		number | english
		-1     | "negative one"
		-99999 | "negative ninety-nine thousand nine hundred ninety-nine"
	}
}
