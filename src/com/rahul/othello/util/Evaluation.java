/**
 * 
 */
package com.rahul.othello.util;

import com.rahul.othello.Board;

/**
 * @author rahular
 * Jan 20, 2015
 */
public class Evaluation {
	public static int score(Board board) {
		// TODO: Improve this function
		
		// Returns the number of white coins on the board
		return board.getPeiceCount(Coin.white);
	}
}
