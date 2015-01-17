package com.rahul.othello.players;

import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

public class RandomPlayer implements Player {

	@Override
	public Point nextMove(Board board) {
		ArrayList<Point> emptySqaures = board.getEmptySquares();
		short index = (short) (Math.random() * emptySqaures.size());
		return emptySqaures.get(index);
	}

}
