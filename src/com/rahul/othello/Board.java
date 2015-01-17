package com.rahul.othello;

import java.util.ArrayList;

public class Board {
	private Coin[][] boardArray;
	private Coin turn;
	
	public Board() {
		boardArray = new Coin[8][8];
		for(short i=0; i<boardArray.length; i++) {
			for(short j=0; j<boardArray[i].length; j++) {
				boardArray[i][j] = Coin.empty;
			}
		}
		
		turn = Coin.white;
	}

	public Coin getPeice(Point point) {
		return boardArray[point.getX()][point.getY()];
	}
	
	public boolean setPeice(Coin coin, Point point) {
		if(this.getPeice(point) == Coin.empty) {
			boardArray[point.getX()][point.getY()] = coin;
			// TODO: Make the necessary flips
			changeTurn();
			return true;
		} else
			return false;
	}
	
	public ArrayList<Point> getEmptySquares() {
		ArrayList<Point> emptySquares = new ArrayList<Point>();
		Point point;
		for(short i=0; i<boardArray.length; i++) {
			for(short j=0; j<boardArray[i].length; j++) {
				point = new Point(i, j);
				if(this.getPeice(point) == Coin.empty)
					emptySquares.add(point);
			}
		}
		return emptySquares;
	}
	
	public short getPeiceCount(Coin peiceType) {
		Point point;
		short count = 0;
		for(short i=0; i<boardArray.length; i++) {
			for(short j=0; j<boardArray[i].length; j++) {
				point = new Point(i, j);
				if(this.getPeice(point) == peiceType)
					count++;
			}
		}
		return count;
	}
	
	public Coin getTurn() {
		return turn;
	}
	
	public void changeTurn() {
		if(turn == Coin.white) turn = Coin.black;
		else turn = Coin.white;
	}
}
