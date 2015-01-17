package com.rahul.othello.players;

import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Coin;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

public class RandomPlayer implements Player {
	
	Coin playerType;
	
	public RandomPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		ArrayList<Point> legalMoves = board.getLegalMoves(playerType);
		short index = (short) (Math.random() * legalMoves.size());
		return legalMoves.get(index);
	}

}
