package com.rahul.othello;

public class Point {
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
