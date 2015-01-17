package com.rahul.othello.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.rahul.othello.Board;
import com.rahul.othello.Coin;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

public class HumanPlayer implements Player {
	
	Coin playerType;
	
	public HumanPlayer(Coin playerType) {
		this.playerType = playerType;
	}
	
	@Override
	public Point nextMove(Board board) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Point squareToPlay = null;
		boolean validInput = false;
		short x = -1, y = -1;

		while (!validInput) {
			System.out.print("Enter move: ");
			try {
				String[] strInputs = br.readLine().split(" ");
				x = Short.parseShort(strInputs[0]);
				y = Short.parseShort(strInputs[1]);
				squareToPlay = new Point(x, y);
				
				if(board.isMoveLegal(playerType, squareToPlay)) {
					validInput = true;
				} else {
					System.err.println("This move is not legal. Try again.");
				}
				
			} catch (Exception e) {
				System.err.println("Invalid format.");
				System.err.println("Acceptable format: <row> <col>");
			}
		}
		return squareToPlay;
	}

}
