package com.rahul.othello;

import java.io.Serializable;

/**
 * A represents a <b>Point</b> or a <b>Square</b> on the board. The top left
 * square on the board is (0, 0) and the bottom right is (7, 7)
 * 
 * @author rahul
 */
public class Point implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private short x, y;

	public Point(short x, short y) {
		this.x = x;
		this.y = y;
	}

	public short getX() {
		return x;
	}

	public short getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof Point))
			return false;

		Point point = (Point) o;
		return this.x == point.getX() && this.y == point.getY();
	}
}
