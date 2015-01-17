package com.rahul.othello.players;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

public class SequentialPlayer implements Player {

	@Override
	public Point nextMove(Board board) {
		return board.getEmptySquares().get(0);
	}

}
