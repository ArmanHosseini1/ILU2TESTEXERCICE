package ilu2;

public class Welcome {
	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ");
		if(input!=null && !input.trim().equals("")) {
			String capInput = input.substring(0,1).toUpperCase() + input.substring(1);
			sb.append(capInput);
		}
		else {
			sb.append("my friend");
		}
		return sb.toString();
	}
}
