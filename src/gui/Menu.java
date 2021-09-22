package gui;

import model.Relationship;
import tools.Out;

public class Menu {

	public static void main() {
		Out.printString("\n***** MAIN MENU *****\n");
		Out.printString("1. Add a new contact");
		Out.printString("2. List all contacts");
		Out.printString("3. List contacts beginning for a char");
		Out.printString("4. List contacts belonging to a group");
		Out.printString("5. Exit");
	}

	public static void relationshipListed() {
		Out.printString("\n***** RELATIONSHIP *****\n");
		for (Relationship relationship : Relationship.BY_ID.values()) {
			Out.printEnum(relationship);
		}
	}

}
