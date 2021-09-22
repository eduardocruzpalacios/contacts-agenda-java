package tools;

import java.util.Scanner;

public class In {

	public static String getString(String msg) {
		Out.printString(msg);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String getString = scanner.nextLine();
		return getString;
	}

	public static String getChar(String msg) {
		String getChar;
		do {
			getChar = getString(msg);
		} while (getChar.length() != 1);
		return getChar;
	}

	public static int getInt() {
		int getInt;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			Out.printString("enter an integer, ¡try again!");
			scanner.next();
		}
		getInt = scanner.nextInt();
		return getInt;
	}

	public static int getIntBetween(int num1, int num2, String msg) {
		boolean exit = false;
		int getIntBetween = 0;
		while (!exit) {
			Out.printString(msg);
			getIntBetween = In.getInt();
			if (getIntBetween >= num1 && getIntBetween <= num2) {
				exit = true;
			}
		}
		return getIntBetween;
	}

}
