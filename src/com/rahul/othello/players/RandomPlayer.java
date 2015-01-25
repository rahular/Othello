package com.rahul.othello.players;

import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;
import com.rahul.othello.util.Coin;

/**
 * Makes a random move
 * 
 * @author rahul
 */
public class RandomPlayer implements Player {
	
	Coin playerType;
	
	public RandomPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		ArrayList<Point> legalMoves = board.getLegalMoves(playerType);
		if(legalMoves.isEmpty()) return null;
		
		short index = (short) (Math.random() * legalMoves.size());
		return legalMoves.get(index);
	}

	@Override
	public String getName() {
		return "Random Player";
	}

}
