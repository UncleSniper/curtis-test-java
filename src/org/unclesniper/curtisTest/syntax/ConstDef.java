package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public class ConstDef extends TopLevel {

	private String name;

	private Expression type;

	private Expression value;

	public ConstDef(Location location, String name, Expression type, Expression value) {
		super(location);
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expression getType() {
		return type;
	}

	public void setType(Expression type) {
		this.type = type;
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

}
