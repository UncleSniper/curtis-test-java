package org.unclesniper.curtisTest.syntax;

import java.util.List;
import java.util.LinkedList;
import org.unclesniper.curtisTest.Location;

public class TypeDef extends Expression {

	public static class Field extends Syntax {

		private String name;

		private Expression type;

		public Field(Location location, String name, Expression type) {
			super(location);
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

	private final List<Expression> supertypes = new LinkedList<Expression>();

	private final List<Field> fields = new LinkedList<Field>();

	public TypeDef(Location location) {
		super(location);
	}

	public Iterable<Expression> getSupertypes() {
		return supertypes;
	}

	public void addSupertypes(Expression supertype) {
		supertypes.add(supertype);
	}

	public Iterable<Field> getFields() {
		return fields;
	}

	public void addField(Field field) {
		fields.add(field);
	}

}
