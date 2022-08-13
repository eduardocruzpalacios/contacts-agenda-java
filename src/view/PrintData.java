package view;

import java.util.Map;

import model.Contact;

public class PrintData {

	public static void string(String message) {
		System.out.println(message);
	}

	public static void enumValue(Enum<?> enumValue) {
		System.out.println(enumValue);
	}

	public static void mapContact(Map<String, Contact> map) {
		map.forEach((String, Contact) -> System.out.println(Contact));
	}

	public static void header(String header) {
		PrintData.string("\n***** " + header + " *****\n");
	}

}
