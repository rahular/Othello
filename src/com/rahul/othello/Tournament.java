package com.rahul.othello;

import com.rahul.othello.players.RandomPlayer;
import com.rahul.othello.players.SequentialPlayer;

public class Tournament {
	private static int numOfGames = 10;
	
	public static void main(String[] args) {
		for(int i=0; i<numOfGames; i++) {
			new Game(new RandomPlayer(), new SequentialPlayer());
		}
	}

}
