package tools;

import java.util.Scanner;

public class In {

	private static Scanner scanner;

	public static String getString(String msg) {
		Print.str(msg);
		scanner = new Scanner(System.in);
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

	public static int getInt(String msg) {
		System.out.println(msg);
		int getInt;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			Print.str(msg);
			scanner.next();
		}
		getInt = scanner.nextInt();
		return getInt;
	}

	public static int getIntBetween(int num1, int num2, String msg) {
		boolean exit = false;
		int getIntBetween = 0;
		while (!exit) {
			getIntBetween = In.getInt(msg);
			if (getIntBetween >= num1 && getIntBetween <= num2) {
				exit = true;
			}
		}
		return getIntBetween;
	}

	public static void closeScanner() {
		scanner.close();
	}

}
