package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public class MemberAccess extends PIExpression {

	private Expression base;

	private String name;

	public MemberAccess(Location location, Expression base, String name) {
		super(location);
		this.base = base;
		this.name = name;
	}

	public Expression getBase() {
		return base;
	}

	public void setBase(Expression base) {
		this.base = base;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
