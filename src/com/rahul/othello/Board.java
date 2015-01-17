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
		
		boardArray[3][3] = boardArray[4][4] = Coin.white;
		boardArray[3][4] = boardArray[4][3] = Coin.black;
		
		turn = Coin.white;
	}

	public Coin getPeice(Point point) {
		return boardArray[point.getX()][point.getY()];
	}
	
	public boolean setPeice(Coin coin, Point point) {
		if(this.getPeice(point) == Coin.empty) {
			boardArray[point.getX()][point.getY()] = coin;
			flipCoins(coin, point);
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
	
	private void flipCoins(Coin coin, Point point) {
		short x = point.getX();
		short y = point.getY();
				
		flipVertical(coin, x, y);
		flipHorizontal(coin, x, y);
		flipDiagonals(coin, x, y);
	}
	
	private void flipVertical(Coin coin, short x, short y) {
		int row;
		boolean flip = false;
		
		// Flip coins above the piece
		for(row = x-1; row >= 0; row--) {
			if(boardArray[row][y] == Coin.empty) break;
			if(boardArray[row][y] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && row >= 0) {
			for(int i = x-1; i >= row; i--) {
				boardArray[i][y] = coin;
			}
		}
		flip = false;
		
		// Flip coins below the piece
		for(row = x+1; row < 8; row++) {
			if(boardArray[row][y] == Coin.empty) break;
			if(boardArray[row][y] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && row < 8) {
			for(int i = x+1; i <= row; i++) {
				boardArray[i][y] = coin;
			}
		}
		flip = false;
	}
	
	private void flipHorizontal(Coin coin, short x, short y) {
		int col;
		boolean flip = false;
		
		// Flip coins to the left of the piece
		for(col = y-1; col >= 0; col--) {
			if(boardArray[x][col] == Coin.empty) break;
			if(boardArray[x][col] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && col >= 0) {
			for(int i = y-1; i >= col; i--) {
				boardArray[x][i] = coin;
			}
		}
		flip = false;
		
		// Flip coins to the right of the piece
		for(col = y+1; col < 8; col++) {
			if(boardArray[x][col] == Coin.empty) break;
			if(boardArray[x][col] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && col < 8) {
			for(int i = y+1; i <= col; i++) {
				boardArray[x][i] = coin;
			}
		}
		flip = false;
	}
	
	private void flipDiagonals(Coin coin, short x, short y) {
		int row, col;
		boolean flip = false;
		
		// Flip upper left
		for(row = x-1, col = y-1; row >= 0 && col >= 0; row--, col--) {
			if(boardArray[row][col] == Coin.empty) break;
			if(boardArray[row][col] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && row >= 0 && col >= 0) {
			for(int i = x-1, j = y-1; i >= row && j >= col; i--, j--) {
				boardArray[i][j] = coin;
			}
		}
		flip = false;
		
		// Flip upper right
		for(row = x-1, col = y+1; row >= 0 && col < 8; row--, col++) {
			if(boardArray[row][col] == Coin.empty) break;
			if(boardArray[row][col] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && row >= 0 && col < 8) {
			for(int i = x-1, j = y+1; i >= row && j <= col; i--, j++) {
				boardArray[i][j] = coin;
			}
		}
		flip = false;
		
		// Flip lower left
		for(row = x+1, col = y-1; row < 8 && col >= 0; row++, col--) {
			if(boardArray[row][col] == Coin.empty) break;
			if(boardArray[row][col] == coin) {
				flip = true;
				break;
			}
		}
		if(flip && row < 8 && col >= 0) {
			for(int i = x+1, j = y-1; i <= row && j >= col; i++, j--) {
				boardArray[i][j] = coin;
			}
		}
		flip = false;
		
		// Flip lower right
		for(row = x+1, col = y+1; row < 8 && col < 8; row++, col++) {
			if(boardArray[row][col] == Coin.empty) break;
			if(boardArray[row][col] == coin) {
				flip = false;
				break;
			}
		}
		if(flip && row < 8 && col < 8) {
			for(int i = x+1, j = y+1; i <= row && j <= col; i++, j++) {
				boardArray[i][j] = coin;
			}
		}
		flip = false;
	}
	
	@Override
	public String toString() {
		String lineSeparator = "   +---+---+---+---+---+---+---+---+\n";
		String heading = "     0   1   2   3   4   5   6   7\n";
		StringBuilder sb = new StringBuilder();
		String coin;
		
		sb.append(heading);
		sb.append(lineSeparator);
		for(int i=0; i<8; i++) {
			sb.append(i + " ");
			for(int j=0; j<8; j++) {
				sb.append(" | ");
				if(boardArray[i][j] == Coin.white) coin = "o";
				else if(boardArray[i][j] == Coin.black) coin = "x";
				else coin = " ";
				sb.append(coin);
			}
			sb.append(" |\n" + lineSeparator);
		}
		return sb.toString();
	}
}
