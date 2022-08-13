package view;

import model.Relationship;

public class Menu {

	public static void main() {
		PrintData.header("MAIN MENU");
		PrintData.string("1. Add a new contact");
		PrintData.string("2. List all contacts");
		PrintData.string("3. List contacts beginning for a char");
		PrintData.string("4. List contacts belonging to a Relationship");
		PrintData.string("5. Exit");
	}

	public static void relationship() {
		PrintData.header("RELATIONSHIP MENU");
		for (Relationship relationship : Relationship.BY_NAME.values()) {
			PrintData.enumConstant(relationship);
		}
	}

}
