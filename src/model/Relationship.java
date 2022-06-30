package model;

import java.util.HashMap;
import java.util.Map;

public enum Relationship {

	FAMILY(), FRIEND(), SCHOOL(), HIGH_SCHOOL(), COLLEGE(), WORK();

	public static final Map<String, Relationship> BY_NAME = new HashMap<>();

	static {
		for (Relationship relationship : values()) {
			BY_NAME.put(relationship.toString(), relationship);
		}
	}

}
