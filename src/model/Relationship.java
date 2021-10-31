package model;

import java.util.HashMap;
import java.util.Map;

import exceptions.RelationshipNotFoundException;
import gui.Menu;
import tools.In;
import tools.Log;

public enum Relationship {

	FAMILY(1), FRIEND(2), SCHOOL(3), HIGH_SCHOOL(5), COLLEGE(6), WORK(7);

	private final int id;

	private Relationship(int id) {
		this.id = id;
	}

	public static final Map<Integer, Relationship> BY_ID = new HashMap<>();

	static {
		for (Relationship relationship : values()) {
			BY_ID.put(relationship.id, relationship);
		}
	}

	public static Relationship valueOfId(int id) {
		return BY_ID.get(id);
	}

	public static Relationship getRelationship(String msg) {
		boolean salir = false;
		String relationshipString;
		do {
			Menu.relationshipListed();
			relationshipString = In.getString(msg).toUpperCase();
			try {
				int count = 0;
				for (Relationship relationship : Relationship.BY_ID.values()) {
					count++;
					if (relationship.toString().equals(relationshipString)) {
						salir = true;
						break;
					}
					if (count == Relationship.BY_ID.size()) {
						throw new RelationshipNotFoundException();
					}
				}
			} catch (RelationshipNotFoundException e) {
				Log.logger.error(e + ": " + relationshipString);
			}
		} while (!salir);
		return Relationship.valueOf(relationshipString);
	}

}
