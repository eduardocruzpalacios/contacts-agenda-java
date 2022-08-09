package view;

import model.Relationship;

public class Menu {

	public static void main() {
		PrintData.header("MAIN MENU");
		PrintData.str("1. Add a new contact");
		PrintData.str("2. List all contacts");
		PrintData.str("3. List contacts beginning for a char");
		PrintData.str("4. List contacts belonging to a Relationship");
		PrintData.str("5. Exit");
	}

	public static void relationship() {
		PrintData.header("RELATIONSHIP MENU");
		for (Relationship relationship : Relationship.BY_NAME.values()) {
			PrintData.enumConstant(relationship);
		}
	}

}
