package view;

import java.util.Scanner;

public class In {

	private static Scanner scanner;

	public static String getString(String msg) {
		PrintData.str(msg);
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private static String getStringOf1Length(String msg) {
		String getStringOf1Length;
		do {
			getStringOf1Length = getString(msg);
		} while (getStringOf1Length.length() != 1);
		return getStringOf1Length;
	}

	public static char getChar(String msg) {
		String string = getStringOf1Length(msg);
		return string.charAt(0);
	}

	public static int getInt(String msg) {
		System.out.println(msg);
		int getInt;
		scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			PrintData.str(msg);
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
