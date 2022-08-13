package view;

import java.util.Scanner;

public class DataForm {

	private static Scanner scanner;

	public static String getString(String message) {
		PrintData.string(message);
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private static String getStringOf1Length(String message) {
		String getStringOf1Length;
		do {
			getStringOf1Length = getString(message);
		} while (getStringOf1Length.length() != 1);
		return getStringOf1Length;
	}

	public static char getChar(String message) {
		String string = getStringOf1Length(message);
		return string.charAt(0);
	}

	public static int getInt(String message) {
		PrintData.string(message);
		int getInt;
		scanner = new Scanner(System.in);
		while (scanner.hasNextInt() == false) {
			PrintData.string(message);
			scanner.next();
		}
		getInt = scanner.nextInt();
		return getInt;
	}

	public static int getIntBetween(int num1, int num2, String message) {
		if (num1 == num2) {
			return num1;
		}
		if (num1 > num2) {
			int aux = num1;
			num1 = num2;
			num2 = aux;
		}
		boolean exit = false;
		int getIntBetween = 0;
		while (!exit) {
			getIntBetween = DataForm.getInt(message);
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
