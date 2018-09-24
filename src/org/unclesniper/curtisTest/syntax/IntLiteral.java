package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public class IntLiteral extends PIExpression {

	private int value;

	public IntLiteral(Location location, int value) {
		super(location);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
