package com.rahul.othello;

import com.rahul.othello.players.*;

public class Tournament {
	private static int numOfGames = 1;
	
	public static void main(String[] args) {
		for(int i=0; i<numOfGames; i++) {
			new Game(new HumanPlayer(), new SequentialPlayer());
		}
	}

}
