package org.unclesniper.curtisTest.syntax;

import java.util.List;
import java.util.LinkedList;
import org.unclesniper.curtisTest.Location;

public class NewExpr extends PIExpression {

	public static class FieldInitializer extends Syntax {

		private String name;

		private Expression value;

		public FieldInitializer(Location location, String name, Expression value) {
			super(location);
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Expression getValue() {
			return value;
		}

		public void setValue(Expression value) {
			this.value = value;
		}

	}

	private Expression type;

	private final List<FieldInitializer> initializers = new LinkedList<FieldInitializer>();

	public NewExpr(Location location, Expression type) {
		super(location);
		this.type = type;
	}

	public Expression getType() {
		return type;
	}

	public void setType(Expression type) {
		this.type = type;
	}

	public Iterable<FieldInitializer> getInitializers() {
		return initializers;
	}

	public void addInitializer(FieldInitializer initializer) {
		initializers.add(initializer);
	}

}
