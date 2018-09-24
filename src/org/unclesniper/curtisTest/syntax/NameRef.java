package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public class NameRef extends PIExpression {

	private String name;

	public NameRef(Location location, String name) {
		super(location);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
