package ilu2;

public class Welcome {
	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder();
		if(input!=null && !input.trim().equals("")) {
			if(!(input).equals(input.toUpperCase())) {
				sb.append("Hello, ");
			String capInput = input.substring(0,1).toUpperCase() + input.substring(1);
			sb.append(capInput);
			}
			else {
				sb.append("HELLO, ");
				sb.append(input.toUpperCase());
				sb.append(" !");
			}
		}
		else {
			sb.append("Hello, my friend");
		}
		return sb.toString();
	}
}
