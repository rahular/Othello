package com.rahul.othello.util;

/**
 * The values which any square on the board may take
 * @author rahul
 */
public enum Coin {
	white, black, empty;

	public Coin change() {
		if(this == white) return black;
		else if(this == black) return white;
		else return empty;
	}
}
