package com.rahul.othello;

/**
 * Every player should implement this interface
 * @author rahul
 */
public interface Player {
	public Point nextMove(Board board);
	public String getName();
}
