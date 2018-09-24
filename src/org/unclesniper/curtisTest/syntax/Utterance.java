package org.unclesniper.curtisTest.syntax;

import java.util.List;
import java.util.LinkedList;

public class Utterance {

	private final List<TopLevel> topLevels = new LinkedList<TopLevel>();

	public Utterance() {}

	public Iterable<TopLevel> getTopLevels() {
		return topLevels;
	}

	public void addTopLevel(TopLevel topLevel) {
		topLevels.add(topLevel);
	}

}
