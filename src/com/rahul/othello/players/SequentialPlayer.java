package com.rahul.othello.players;

import com.rahul.othello.Board;
import com.rahul.othello.Coin;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

/**
 * Places the coin on the first legal square on the board
 * 
 * @author rahul
 */
public class SequentialPlayer implements Player {

	Coin playerType;

	public SequentialPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		return board.getLegalMoves(playerType).get(0);
	}

}
