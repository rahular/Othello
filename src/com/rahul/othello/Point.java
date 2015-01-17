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
}
