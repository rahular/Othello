/**
 * 
 */
package com.rahul.othello.util;

import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Point;

/**
 * @author rahular Jan 20, 2015
 */
public class TreeWalk {
	public static Point askMinimax(Board board, Coin side, int depth, boolean max) {
		return minimax(board, side, depth, max).move;
	}
	
	private static MoveScore minimax(Board board, Coin side, int depth, boolean max) {		
		if (depth == 0)
			return new MoveScore(Evaluation.score(board), null);

		MoveScore moveScore, tempScore;
		moveScore = new MoveScore();
		ArrayList<Point> legalMoves = board.getLegalMoves(side);
		
		if(legalMoves.isEmpty())
			return new MoveScore(Evaluation.score(board), null);

		if (max)
			moveScore.eval = Integer.MIN_VALUE;
		else
			moveScore.eval = Integer.MAX_VALUE;

		for (Point move : legalMoves) {
			Board child = (Board) board.clone();
			child.setPiece(side, move);
			if (max) {
				tempScore = minimax(child, side.change(), depth - 1, !max);
				if(tempScore.eval > moveScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
			}
			else {
				tempScore = minimax(child, side.change(), depth - 1, !max);
				if(tempScore.eval < moveScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
			}
		}
		return moveScore;
	}
}

class MoveScore {
	int eval;
	Point move;
	
	public MoveScore() {}
	
	public MoveScore(int evalScore, Point move) {
		this.eval = evalScore;
		this.move = move;
	}
}
