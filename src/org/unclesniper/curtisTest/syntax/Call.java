package org.unclesniper.curtisTest.syntax;

import java.util.List;
import java.util.LinkedList;
import org.unclesniper.curtisTest.Location;

public class Call extends PIExpression {

	private Expression function;

	private final List<Expression> arguments = new LinkedList<Expression>();

	public Call(Location location, Expression function) {
		super(location);
		this.function = function;
	}

	public Expression getFunction() {
		return function;
	}

	public void setFunction(Expression function) {
		this.function = function;
	}

	public Iterable<Expression> getArguments() {
		return arguments;
	}

	public void addArgument(Expression argument) {
		arguments.add(argument);
	}

}
