package org.unclesniper.curtisTest;

public class UnexpectedCharacterException extends RuntimeException {

	private final Location location;

	private final char badChar;

	public UnexpectedCharacterException(Location location, char badChar) {
		super("Unexpected character at " + location + ": " + badChar);
		this.location = location;
		this.badChar = badChar;
	}

	public Location getLocation() {
		return location;
	}

	public char getBadChar() {
		return badChar;
	}

}
