package model;

import java.util.HashMap;
import java.util.Map;

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

}
