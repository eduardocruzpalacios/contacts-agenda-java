package model;

public class Contact {

	private String name;
	private String phone;
	private Relationship relationship;

	public Contact() {
	}

	public Contact(String name, String phone, Relationship relationship) {
		this.name = name;
		this.phone = phone;
		this.relationship = relationship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", relationship=" + relationship + "]";
	}

}
