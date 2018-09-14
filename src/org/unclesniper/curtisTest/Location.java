package org.unclesniper.curtisTest;

public class Location {

	private final String file;

	private final int line;

	private final int column;

	public Location(String file, int line, int column) {
		this.file = file;
		this.line = line;
		this.column = column;
	}

	public String getFile() {
		return file;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(file);
		builder.append(':');
		builder.append(String.valueOf(line));
		builder.append(':');
		builder.append(String.valueOf(column));
		return builder.toString();
	}

}
