package com.rahul.othello.players;

import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;
import com.rahul.othello.util.Coin;

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
		ArrayList<Point> legalMoves =  board.getLegalMoves(playerType);
		if(legalMoves.isEmpty()) return null;
		else return legalMoves.get(0);
	}

}
