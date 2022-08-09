package utility;

import java.util.Map;

import model.Contact;

public class Print {

	public static void str(String msg) {
		System.out.println(msg);
	}

	public static void enumConstant(Enum<?> listed) {
		System.out.println(listed);
	}

	public static void mapContact(Map<String, Contact> map) {
		map.forEach((String, Contact) -> System.out.println(Contact));
	}

	public static void header(String header) {
		Print.str("\n***** " + header + " *****\n");
	}

}
