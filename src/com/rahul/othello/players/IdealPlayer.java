package com.rahul.othello.players;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;
import com.rahul.othello.util.Coin;
import com.rahul.othello.util.Difficulty;
import com.rahul.othello.util.TreeWalk;

public class IdealPlayer implements Player {

	Coin playerType;
	int difficultyLevel;

	public IdealPlayer(Coin playerType) {
		this.playerType = playerType;
		this.difficultyLevel = Difficulty.medium;
	}
	
	public IdealPlayer(Coin playerType, int difficultyLevel) {
		this.playerType = playerType;
		this.difficultyLevel = difficultyLevel;
	}

	@Override
	public Point nextMove(Board board) {
		boolean shouldMaximize = false;

		if (playerType == Coin.white)
			shouldMaximize = true;
		return TreeWalk.askMinimax(board, playerType, difficultyLevel,
				shouldMaximize);
	}

}
