package homework6;

import java.util.HashMap;

public class StringUtils {

	private static HashMap<String, String> numbersMap = new HashMap<>();

	static {
		numbersMap.put("one", "1");
		numbersMap.put("two", "2");
		numbersMap.put("three", "3");
		numbersMap.put("four", "4");
		numbersMap.put("five", "5");
		numbersMap.put("six", "6");
		numbersMap.put("seven", "7");
		numbersMap.put("eight", "8");
		numbersMap.put("nine", "9");
	}

	public static String removeSpaces(String s) {

		return s.replaceAll("\\s+", "");
	}

	public static String replaceNumbers(String s) {
		String[] tokens = s.split(" ");

		for (int i = 0; i < tokens.length; i++) {
			String currentelement = tokens[i];

			if (numbersMap.containsKey(currentelement)) {
				String value = numbersMap.get(currentelement);
				tokens[i] = value;
			}

			if (numbersMap.containsKey(currentelement.toLowerCase())) {
				String value = numbersMap.get(currentelement.toLowerCase());
				tokens[i] = value;
			}
		}

		return fromArrayToString(tokens);
	}

	private static String fromArrayToString(String[] array) {
		String resultString = "";

		for (int i = 0; i < array.length; i++) {
			resultString = resultString + array[i] + " ";
		}

		return resultString.substring(0, resultString.length() - 1);
	}

}
