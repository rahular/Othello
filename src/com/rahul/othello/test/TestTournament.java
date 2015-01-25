package com.rahul.othello.test;

import com.rahul.othello.util.Timer;

/**
 * A driver class which is used to simulate a tournament of <i>n</i> games
 * 
 * @author rahul
 */
public class TestTournament {
	private static int numOfGames = 100;
	public static boolean debug = false;

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.startTimer();

		for (int i = 0; i < numOfGames; i++) {
			new TestGame().play();
		}
		timer.stopTimer();

		System.out.printf("%50s %3.2f%n", "Elapsed time (seconds)",
				timer.getElapsedTime());
	}
}

