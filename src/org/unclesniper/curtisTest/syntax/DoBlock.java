package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public class DoBlock extends TopLevel {

	private Expression expression;

	public DoBlock(Location location, Expression expression) {
		super(location);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
