package com.rahul.othello;

import com.rahul.othello.players.IdealPlayer;
import com.rahul.othello.players.RandomPlayer;
import com.rahul.othello.util.Algorithm;
import com.rahul.othello.util.Coin;
import com.rahul.othello.util.Difficulty;
import com.rahul.othello.util.Timer;

/**
 * A driver class which is used to simulate a tournament of <i>n</i> games
 * 
 * @author rahul
 */
public class Tournament {
	private static int numOfGames = 100;
	public static boolean debug = false;

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.startTimer();

		int whiteWins = 0, blackWins = 0, draws = 0, score;
		Player whitePlayer = new RandomPlayer(Coin.white);
		Player blackPlayer = new IdealPlayer(Coin.black, Difficulty.medium, Algorithm.minimax);

		for (int i = 0; i < numOfGames; i++) {
			score = new Game(whitePlayer, blackPlayer).play();
			if (score == 1)
				whiteWins++;
			else if (score == 0)
				draws++;
			else
				blackWins++;
		}
		timer.stopTimer();

		System.out.printf("%50s %3d%n", "Total games played", numOfGames);
		System.out.printf("%50s %3d%n", whitePlayer.getName()
				+ " wins", whiteWins);
		System.out.printf("%50s %3d%n", "Games drawn", draws);
		System.out.printf("%50s %3d%n", blackPlayer.getName()
				+ " wins", blackWins);
		System.out.printf("%50s %3.2f%n", "Elapsed time (seconds)",
				timer.getElapsedTime());
	}
}
