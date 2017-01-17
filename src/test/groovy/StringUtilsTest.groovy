import spock.lang.Specification

class StringUtilsTest extends Specification {
	def "reverse a string"() {
		expect:
		StringUtils.reverse(string) == reversed

		where:
		string | reversed
		"abc"  | "cba"
	}

	def "split a list into equal-sized chunks"() {
		expect:
		StringUtils.splitBySize(string, size) == reversed

		where:
		string | size | reversed
		"abc"  | 1    | ["a", "b", "c"]
		"abc"  | 2    | ["ab", "c"]
		"abc"  | 3    | ["abc"]
		"abc"  | 4    | ["abc"]
	}

	def "trim trailing space"() {
		setup:
		StringBuilder builder = new StringBuilder(" ")

		when:
		StringUtils.trimTrailingSpace(builder)

		then:
		builder.toString() == ""
	}

	def "do not trim trailing letter"() {
		setup:
		StringBuilder builder = new StringBuilder(" a")

		when:
		StringUtils.trimTrailingSpace(builder)

		then:
		builder.toString() == " a"
	}
}
