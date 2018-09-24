package org.unclesniper.curtisTest.syntax;

import org.unclesniper.curtisTest.Location;

public abstract class Syntax {

	private Location location;

	public Syntax(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
