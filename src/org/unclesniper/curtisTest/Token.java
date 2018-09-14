package org.unclesniper.curtisTest;

public class Token {

	enum Type {
		INT,
		NAME,
		CONST,
		COLON,
		EQUALS,
		FUN,
		LEFT_ROUND,
		RIGHT_ROUND,
		COMMA,
		GREATER,
		LESS,
		TYPE,
		LEFT_CURLY,
		RIGHT_CURLY,
		DO,
		DOT,
		NEW
	}

	private Location location;

	private Type type;

	private String text;

	public Token(Location location, Type type, String text) {
		this.location = location;
		this.type = type;
		this.text = text;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
