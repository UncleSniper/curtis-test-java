package org.unclesniper.curtisTest;

import java.io.Reader;
import java.util.Deque;
import java.io.IOException;
import java.util.LinkedList;

public class Lexer {

	private enum State {
		NONE,
		INT,
		NAME
	}

	private Reader reader;

	private String file;

	private int line = 1;

	private int column = 1;

	private int start;

	private final char[] chbuf = new char[128];

	private final Deque<Token> tokens = new LinkedList<Token>();

	private State state = State.NONE;

	private StringBuilder buffer;

	public Lexer(Reader reader, String file) {
		this.reader = reader;
		this.file = file;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Location getLocation() {
		return new Location(file, line, column);
	}

	public Token nextToken() throws IOException {
		while(tokens.isEmpty()) {
			int count = reader.read(chbuf);
			if(count <= 0) {
				endUnit();
				if(tokens.isEmpty())
					return null;
			}
			else
				feedChars(chbuf, 0, count);
		}
		return tokens.removeFirst();
	}

	private void emitToken(Token.Type type, String text) {
		tokens.add(new Token(new Location(file, line, start), type, text));
	}

	private void emitToken(Token.Type type) {
		String text = buffer.toString();
		buffer = null;
		emitToken(type, text);
	}

	private void unexpected(char c) {
		throw new UnexpectedCharacterException(getLocation(), c);
	}

	public void feedChars(char[] chars, int offset, final int length) {
		final int end = offset + length;
		for(; offset < end; ++offset) {
			final char c = chars[offset];
			switch(state) {
				case NONE:
					start = column;
					switch(c) {
						case '\n':
						case '\r':
						case '\t':
						case '\f':
						case ' ':
							break;
						case ':':
							emitToken(Token.Type.COLON, ":");
							break;
						case '=':
							emitToken(Token.Type.EQUALS, "=");
							break;
						case '(':
							emitToken(Token.Type.LEFT_ROUND, "(");
							break;
						case ')':
							emitToken(Token.Type.RIGHT_ROUND, ")");
							break;
						case ',':
							emitToken(Token.Type.COMMA, ",");
							break;
						case '>':
							emitToken(Token.Type.GREATER, ">");
							break;
						case '<':
							emitToken(Token.Type.LESS, "<");
							break;
						case '{':
							emitToken(Token.Type.LEFT_CURLY, "{");
							break;
						case '}':
							emitToken(Token.Type.RIGHT_CURLY, "}");
							break;
						default:
							if(c >= '0' && c <= '9') {
								buffer = new StringBuilder(c);
								state = State.INT;
							}
							else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
								buffer = new StringBuilder(c);
								state = State.NAME;
							}
							else
								unexpected(c);
							break;
					}
					break;
				case INT:
					if(c >= '0' && c <= '9')
						buffer.append(c);
					else {
						state = State.NONE;
						emitToken(Token.Type.INT);
						--offset;
						continue;
					}
					break;
				case NAME:
					if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_')
						buffer.append(c);
					else {
						state = State.NONE;
						emitToken(Token.Type.NAME);
						--offset;
						continue;
					}
					break;
				default:
					throw new Error("Unrecognized lexer state: " + state.name());
			}
			if(c == '\n') {
				++line;
				column = 1;
			}
			else
				++column;
		}
	}

	public void endUnit() {
		switch(state) {
			case NONE:
				break;
			case INT:
				state = State.NONE;
				emitToken(Token.Type.INT);
				break;
			case NAME:
				state = State.NONE;
				emitToken(Token.Type.NAME);
				break;
			default:
				throw new Error("Unrecognized lexer state: " + state.name());
		}
	}

}
