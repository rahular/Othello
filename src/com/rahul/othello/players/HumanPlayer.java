package com.rahul.othello.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;

public class HumanPlayer implements Player {

	@Override
	public Point nextMove(Board board) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean validInput = false;
		short x = -1, y = -1;

		while (!validInput) {
			System.out.print("Enter move: ");
			try {
				String[] strInputs = br.readLine().split(" ");
				x = Short.parseShort(strInputs[0]);
				y = Short.parseShort(strInputs[1]);
				validInput = true;
			} catch (Exception e) {
				System.err.println("Invalid format.");
				System.err.println("Acceptable format: <row> <col>");
			}
		}
		return new Point(x, y);
	}

}
