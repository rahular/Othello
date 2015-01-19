package com.rahul.othello;

import com.rahul.othello.players.*;

/**
 * A driver class which is used to simulate a tournament of <i>n</i> games
 * 
 * @author rahul
 */
public class Tournament {
	private static int numOfGames = 1;

	public static void main(String[] args) {
		for (int i = 0; i < numOfGames; i++) {
			new Game(new HumanPlayer(Coin.white), new SequentialPlayer(
					Coin.black));
		}
	}

}
