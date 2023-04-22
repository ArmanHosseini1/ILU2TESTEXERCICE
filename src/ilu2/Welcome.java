package ilu2;

public class Welcome {
	public static StringBuilder construct(StringBuilder sb, String input) {
		sb.append("Hello, ");
		String[] splittedInput = input.split(",");
		for(int i = 0 ; i<splittedInput.length ; i++) {
			splittedInput[i] = splittedInput[i].trim();
			if(!splittedInput[i].equals("")) {
			splittedInput[i] = splittedInput[i].substring(0,1).toUpperCase() + splittedInput[i].substring(1);
			}
			sb.append(splittedInput[i]);
			if(i!=1 && splittedInput.length==2) {
			sb.append(", ");
			}
		}
		return sb;
	}
	
	public static StringBuilder constructMaj(StringBuilder sb, String input) {
		sb.append("HELLO, ");
		String[] splittedInput = input.split(",");
		for(int i = 0 ; i<splittedInput.length ; i++) {
			splittedInput[i] = splittedInput[i].trim();
			if(!splittedInput[i].equals("")) {
			splittedInput[i] = splittedInput[i].substring(0,1).toUpperCase() + splittedInput[i].substring(1);
			}
			sb.append(splittedInput[i]);
			if(i!=1 && splittedInput.length == 2) {
			sb.append(", ");
			}
		}
		sb.append(" !");
		return sb;
	}
	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder();
		if(input!=null && !input.trim().equals("")) {
			if(!(input).equals(input.toUpperCase())) {
				sb = construct(sb, input);
			}
			else {
				sb = constructMaj(sb, input);
			}
		}
		else {
			sb.append("Hello, my friend");
		}
		return sb.toString();
	}
}
