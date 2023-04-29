package ilu2;

public class Welcome {
	
	private static boolean find(String[] input, String toFind) {
		boolean find = false;
		for(int i = 0 ; i<actualLength(input) ; i++ ) {
			if((input[i].length())>=(toFind.length())) {
				if(input[i].substring(0, toFind.length()).equals(toFind))
					find = true;
			}
		}
		return find;
	}
	
	
	
	private static void constructLowercase(StringBuilder sb, String[] input) {
		if(!find(input, "Yoda"))
			sb.append("Hello, ");
		for(int i = 0 ; i<actualLength(input) ; i++) {
			if(!input[i].equals("")) {
				sb.append(input[i]);
			}
			if(i<(actualLength(input)-2)) {
				sb.append(", ");
			}
			else if(i==(actualLength(input)-2)) {
				sb.append(" and ");
			}
		}
		if(find(input, "Yoda"))
			sb.append(", Hello");
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
		if(actualLength(splittedInputLow)>0) {
			constructLowercase(sb, splittedInputLow);
		}
		if(actualLength(splittedInputUp) >0) {
			if(actualLength(splittedInputLow) >0) {
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
				splittedInputUp[k] = splittedInput[i].trim();
				k++;
			} else {
				splittedInputLow[j] = splittedInput[i].trim();
				if(!splittedInputLow[j].equals("")) 
					splittedInputLow[j] = splittedInputLow[j].substring(0,1).toUpperCase() + splittedInputLow[j].substring(1);
				j++;
			}
		}
		splittedInputLow = constructNumeration(splittedInputLow);
		splittedInputUp = constructNumeration(splittedInputUp);
		constructEffective(sb, splittedInputLow, splittedInputUp);
	}
	
	
	
	private static String[] constructNumeration(String[] input) {
		String[] inputSansDoublon = new String[input.length];
		int[] numeration = new int[input.length];
		int compteur = 0;
		boolean toFind = false;
		for(int i = 0 ; i<input.length ; i++) {
			toFind = false;
			for(int j = 0 ; j<compteur ; j++) {
				if(inputSansDoublon[j].equals(input[i])) {
					numeration[j] ++;
					toFind = true;
			}
			}
			if(!toFind) {
				inputSansDoublon[compteur] = input[i];
				numeration[compteur] = 1;
				compteur++;
			}
		}
		return constructMerge(inputSansDoublon, numeration);
	}
	
	
	
	private static String[] constructMerge(String[] inputSansDoublon, int[] numeration) {
		for(int i = 0 ; i<actualLength(inputSansDoublon) ; i++) {
			if(numeration[i] != 1) {
				StringBuilder tempString = new StringBuilder();
				tempString.append(inputSansDoublon[i]);
				tempString.append(" (*");
				tempString.append(numeration[i]);
				tempString.append(")");
				inputSansDoublon[i] = tempString.toString();
			}
		}
		return inputSansDoublon;
	}
	
	
	
	private static int actualLength(String[] input) {
		int length = 0;
		for(int i = 0 ; i<input.length ; i++) {
			if(input[i]!=null)
				length++;
		}
		return length;
	}
	
	
	
	private static void constructMaj(StringBuilder sb, String[] input) {
		if(!find(input, "YODA"))
			sb.append("HELLO, ");
		for(int i = 0 ; i<actualLength(input) ; i++) {
			if(!input[i].equals("")) {
				sb.append(input[i]);
			}
			if(i<(actualLength(input)-2)) {
				sb.append(", ");
			}
			else if(i == (actualLength(input) - 2)) {
				sb.append(" AND ");
			}
			}
		if(find(input, "YODA"))
			sb.append(", HELLO");
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
