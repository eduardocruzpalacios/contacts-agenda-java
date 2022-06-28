package gui;

import model.Relationship;
import tools.Print;

public class Menu {

	public static void main() {
		Print.header("MAIN MENU");
		Print.str("1. Add a new contact");
		Print.str("2. List all contacts");
		Print.str("3. List contacts beginning for a char");
		Print.str("4. List contacts belonging to a Relationship");
		Print.str("5. Exit");
	}

	public static void relationship() {
		Print.header("RELATIONSHIP MENU");
		for (Relationship relationship : Relationship.BY_ID.values()) {
			Print.enums(relationship);
		}
	}

}
