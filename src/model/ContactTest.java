package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testConstructorAndGetters() {
		// given
		String name = "Jhon Doe";
		String phone = "123456789";
		Relationship relationship = Relationship.COLLEGE;

		// when
		Contact contact = new Contact(name, phone, relationship);

		// then
		assertAll("contact",
				() -> assertEquals(name, contact.getName()),
				() -> assertEquals(phone, contact.getPhone()),
				() -> assertEquals(relationship, contact.getRelationship())
		);
	}

	@Test
	void testSetters() {
		// given
		String name = "Jhon Doe";
		String phone = "123456789";
		Relationship relationship = Relationship.COLLEGE;

		// when
		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhone(phone);
		contact.setRelationship(relationship);

		// then
		assertAll("contact",
				() -> assertEquals(name, contact.getName()),
				() -> assertEquals(phone, contact.getPhone()),
				() -> assertEquals(relationship, contact.getRelationship())
		);
	}

	@Test
	void shouldHaveToStringMethodOverride() {
		// given
		Contact contact = new Contact();

		// when
		String toString = contact.toString();

		// then
		assertNotEquals(contact.hashCode(), toString);
	}

}
