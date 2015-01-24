package com.rahul.othello;

import com.rahul.othello.players.IdealPlayer;
import com.rahul.othello.players.RandomPlayer;
import com.rahul.othello.util.Coin;
import com.rahul.othello.util.Difficulty;

/**
 * A driver class which is used to simulate a tournament of <i>n</i> games
 * 
 * @author rahul
 */
public class Tournament {
	private static int numOfGames = 10;
	public static boolean debug = false;

	public static void main(String[] args) {
		int whiteWins = 0, blackWins = 0, draws = 0, score;
		Player whitePlayer = new RandomPlayer(Coin.white);
		Player blackPlayer = new IdealPlayer(Coin.black, Difficulty.easy);

		for (int i = 0; i < numOfGames; i++) {
			score = new Game(whitePlayer, blackPlayer).play();
			if (score == 1)
				whiteWins++;
			else if (score == 0)
				draws++;
			else
				blackWins++;
		}

		System.out.printf("%50s %3d%n", "Total games played", numOfGames);
		System.out.printf("%50s %3d%n", whitePlayer.getClass().getName()
				+ " wins", whiteWins);
		System.out.printf("%50s %3d%n", "Games drawn", draws);
		System.out.printf("%50s %3d%n", blackPlayer.getClass().getName()
				+ " wins", blackWins);
	}
}
