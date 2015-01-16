package com.rahul.othello;

public class Board {
	private Coin[][] boardArray;

	public Coin getPeice(Point point) {
		return boardArray[point.getX()][point.getY()];
	}
	
	public boolean setPeice(Coin coin, Point point) {
		if(this.getPeice(point) == Coin.empty) {
			boardArray[point.getX()][point.getY()] = coin;
			// TODO: Make the necessary flips
			return true;
		} else
			return false;
	}
}
