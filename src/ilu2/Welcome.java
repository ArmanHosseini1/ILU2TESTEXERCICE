package ilu2;

public class Welcome {
	private static void constructLowercase(StringBuilder sb, String[] input) {
		sb.append("Hello, ");
		for(int i = 0 ; i<input.length ; i++) {
			input[i] = input[i].trim();
			if(!input[i].equals("")) {
				input[i] = input[i].substring(0,1).toUpperCase() + input[i].substring(1);
				sb.append(input[i]);
			}
			if(i<(input.length-2)) {
				sb.append(", ");
			}
			else if(i==(input.length)-2) {
				sb.append(" and ");
			}
		}
	}
	private static int lengthUp(String[] splittedInput) {
		int j = 0;
		for(int i = 0 ; i<splittedInput.length ; i++) {
			if(splittedInput[i].equals(splittedInput[i].toUpperCase())) {
				j++;
			}
		}
		return j;
	}
	
	private static void constructEffective(StringBuilder sb, String[] splittedInputLow, String[] splittedInputUp) {
		if(splittedInputLow.length>0) {
		constructLowercase(sb, splittedInputLow);
		}
		if(splittedInputUp.length >0) {
			if(splittedInputLow.length >0) {
		sb.append(". AND ");
			}
		constructMaj(sb, splittedInputUp);
		}
	}
	
	private static void construct(StringBuilder sb, String input) {
		String[] splittedInput = input.split(",");
		int lengthUp = lengthUp(splittedInput);
		String[] splittedInputLow = new String[splittedInput.length - lengthUp];
		String[] splittedInputUp = new String[lengthUp];
		int j = 0, k = 0;
		for(int i = 0 ; i<splittedInput.length ; i++) {
			if(splittedInput[i].equals(splittedInput[i].toUpperCase())) {
				splittedInputUp[k] = splittedInput[i];
				k++;
			} else {
				splittedInputLow[j] = splittedInput[i];
				j++;
			}
		}
		constructEffective(sb, splittedInputLow, splittedInputUp);
	}
	
	private static void constructMaj(StringBuilder sb, String[] input) {
		sb.append("HELLO, ");
		for(int i = 0 ; i<input.length ; i++) {
			input[i] = input[i].trim();
			if(!input[i].equals("")) {
				input[i] = input[i].substring(0,1).toUpperCase() + input[i].substring(1);
				sb.append(input[i]);
			}
			if(i<(input.length-2)) {
				sb.append(", ");
			}
			else if(i == (input.length - 2)) {
				sb.append(" AND ");
			}
			}
		sb.append(" !");
	}
	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder();
		if(input!=null && !input.trim().equals("")) {
			construct(sb, input);
		}
		else {
			sb.append("Hello, my friend");
		}
		return sb.toString();
	}
}
