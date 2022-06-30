package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RelationshipTest {

	@Test
	void testConstants() {
		assertAll("constants names",
				() -> assertEquals("FAMILY", Relationship.FAMILY.toString()),
				() -> assertEquals("FRIEND", Relationship.FRIEND.toString()),
				() -> assertEquals("SCHOOL", Relationship.SCHOOL.toString()),
				() -> assertEquals("HIGH_SCHOOL", Relationship.HIGH_SCHOOL.toString()),
				() -> assertEquals("COLLEGE", Relationship.COLLEGE.toString()),
				() -> assertEquals("WORK", Relationship.WORK.toString())
		);
	}

	@Test
	void shouldFillACollectionWithAllEnumConstants() {
		// Given
		int constantsNumber = Relationship.values().length;

		// When
		int collectionSize =Relationship.BY_NAME.size();

		// Then
		assertEquals(constantsNumber, collectionSize);
	}

}
