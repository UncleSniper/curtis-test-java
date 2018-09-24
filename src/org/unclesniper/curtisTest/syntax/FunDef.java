package org.unclesniper.curtisTest.syntax;

import java.util.List;
import java.util.LinkedList;
import org.unclesniper.curtisTest.Location;

public class FunDef extends Expression {

	public static class Parameter {

		private String name;

		private Expression type;

		public Parameter(String name, Expression type) {
			this.name = name;
			this.type = type;
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

	}

	private final List<Parameter> parameters = new LinkedList<Parameter>();

	private Expression returnType;

	private Expression body;

	public FunDef(Location location, Expression returnType, Expression body) {
		super(location);
		this.returnType = returnType;
		this.body = body;
	}

	public Iterable<Parameter> getParameters() {
		return parameters;
	}

	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	public Expression getReturnType() {
		return returnType;
	}

	public void setReturnType(Expression returnType) {
		this.returnType = returnType;
	}

	public Expression getBody() {
		return body;
	}

	public void setBody(Expression body) {
		this.body = body;
	}

}
