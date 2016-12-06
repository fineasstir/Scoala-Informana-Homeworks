package homework6;

public class Main {

	public static void main(String[] args) {

		StringUtils su = new StringUtils();
		String s1 = su.removeSpaces("  saa");
		System.out.println(s1);

		String s2 = su.replaceNumbers("  s one aa");
		System.out.println(s2);

	}

}
