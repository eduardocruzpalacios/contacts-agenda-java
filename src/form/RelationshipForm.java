package form;

import exceptions.RelationshipNotFoundException;
import gui.Menu;
import model.Relationship;
import tools.In;
import tools.Log;

public class RelationshipForm {

	public static Relationship getRelationship() {
		boolean exit = false;
		String relationshipString;
		do {
			Menu.relationship();
			relationshipString = In.getString("Relationship:").toUpperCase();
			try {
				int count = 0;
				for (Relationship relationship : Relationship.BY_ID.values()) {
					count++;
					if (relationship.toString().equals(relationshipString)) {
						exit = true;
						break;
					}
					if (count == Relationship.BY_ID.size()) {
						throw new RelationshipNotFoundException();
					}
				}
			} catch (RelationshipNotFoundException e) {
				Log.logger.error(e + ": " + relationshipString);
			}
		} while (!exit);
		return Relationship.valueOf(relationshipString);
	}

}
