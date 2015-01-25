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
	public static Point askMinimax(Board board, Coin side, int depth,
			boolean max) {
		return minimax(board, side, depth, max).move;
	}

	public static Point askAlphaBeta(Board board, Coin side, int depth,
			boolean max) {
		return alphaBeta(board, side, depth, max, Integer.MIN_VALUE,
				Integer.MAX_VALUE).move;
	}

	private static MoveScore minimax(Board board, Coin side, int depth,
			boolean max) {
		if (depth == 0) {
			return new MoveScore(Evaluation.score(board), null);
		}

		ArrayList<Point> legalMoves = board.getLegalMoves(side);

		if (legalMoves.isEmpty()) {
			return new MoveScore(Evaluation.score(board), null);
		}

		if (max) {
			MoveScore moveScore = new MoveScore();
			moveScore.eval = Integer.MIN_VALUE;
			for (Point move : legalMoves) {
				Board child = (Board) board.clone();
				child.setPiece(side, move);
				MoveScore tempScore = minimax(child, side.change(), depth - 1, !max);
				if(moveScore.eval < tempScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
			}
			return moveScore;
		} else {
			MoveScore moveScore = new MoveScore();
			moveScore.eval = Integer.MAX_VALUE;
			for (Point move : legalMoves) {
				Board child = (Board) board.clone();
				child.setPiece(side, move);
				MoveScore tempScore = minimax(child, side.change(), depth - 1, !max);
				if(moveScore.eval > tempScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
			}
			return moveScore;
		}
	}

	private static MoveScore alphaBeta(Board board, Coin side, int depth,
			boolean max, int alpha, int beta) {
		if (depth == 0)
			return new MoveScore(Evaluation.score(board), null);

		ArrayList<Point> legalMoves = board.getLegalMoves(side);

		if (legalMoves.isEmpty())
			return new MoveScore(Evaluation.score(board), null);

		if (max) {
			MoveScore moveScore = new MoveScore();
			moveScore.eval = Integer.MIN_VALUE;
			for (Point move : legalMoves) {
				Board child = (Board) board.clone();
				child.setPiece(side, move);
				MoveScore tempScore = alphaBeta(child, side.change(), depth - 1, !max,
						alpha, beta);
				if(moveScore.eval < tempScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
				alpha = max(alpha, moveScore.eval);
				if (beta <= alpha)
					break;
			}
			return moveScore;
		} else {
			MoveScore moveScore = new MoveScore();
			moveScore.eval = Integer.MAX_VALUE;
			for (Point move : legalMoves) {
				Board child = (Board) board.clone();
				child.setPiece(side, move);
				MoveScore tempScore = alphaBeta(child, side.change(), depth - 1, !max,
						alpha, beta);
				if(moveScore.eval > tempScore.eval) {
					moveScore.eval = tempScore.eval;
					moveScore.move = move;
				}
				alpha = min(alpha, moveScore.eval);
				if (beta <= alpha)
					break;
			}
			return moveScore;
		}
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}

class MoveScore {
	int eval;
	Point move;

	public MoveScore() {
	}

	public MoveScore(int evalScore, Point move) {
		this.eval = evalScore;
		this.move = move;
	}
	
	@Override
	public String toString() {
		return "Score: " + eval + "\nMove: " + move;
	}
}
