package view;

import java.util.Map;

import model.Contact;

public class PrintData {

	public static void string(String string) {
		System.out.println(string);
	}

	public static void enumValue(Enum<?> enumValue) {
		System.out.println(enumValue);
	}

	public static void contacts(Map<String, Contact> contacts) {
		contacts.forEach((key, value) -> System.out.println(value));
	}

	public static void header(String header) {
		PrintData.string("\n***** " + header + " *****\n");
	}

}
