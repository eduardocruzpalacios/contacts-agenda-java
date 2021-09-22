package exceptions;

public class RelationshipNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RelationshipNotFoundException() {
		super();
	}

	public RelationshipNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "RelationshipNotFoundException []";
	}

}
