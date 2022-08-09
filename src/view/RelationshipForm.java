package view;

import model.Relationship;

public class RelationshipForm {

	public static Relationship getRelationship() {
		boolean exit = false;
		String relationshipString;
		do {
			Menu.relationship();
			relationshipString = DataForm.getString("Relationship:").toUpperCase();
			for (Relationship relationship : Relationship.BY_NAME.values()) {
				if (relationship.toString().equals(relationshipString)) {
					exit = true;
					break;
				}
			}
		} while (!exit);
		return Relationship.valueOf(relationshipString);
	}

}
