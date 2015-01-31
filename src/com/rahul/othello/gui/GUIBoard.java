package com.rahul.othello.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.rahul.othello.Board;
import com.rahul.othello.Point;
import com.rahul.othello.players.IdealPlayer;
import com.rahul.othello.util.Algorithm;
import com.rahul.othello.util.Coin;
import com.rahul.othello.util.Difficulty;

public class GUIBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton[][] buttons;
	private Board board;
	private GUIGame game;

	public GUIBoard() {
		game = new GUIGame(null, new IdealPlayer(Coin.black,
				Difficulty.medium, Algorithm.alphaBeta));
		this.setBoard(game.getBoard());
		initUI();
		this.setVisible(true);
	}

	public GUIBoard(Board board) {
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void initUI() {
		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(8, 8, 5, 5));

		this.buttons = new JButton[8][8];

		for (short i = 0; i < 8; i++) {
			for (short j = 0; j < 8; j++) {
				Coin piece = board.getPeice(new Point(i, j));
				if (piece != Coin.empty) {
					this.buttons[i][j] = new JButton(
							(piece == Coin.white) ? "O" : "X");
					panel.add(this.buttons[i][j]);
				} else {
					this.buttons[i][j] = new JButton(".");
					panel.add(this.buttons[i][j]);
				}
				buttons[i][j].addActionListener(this);
				if (buttons[i][j].getText().equals("X"))
					buttons[i][j].setBackground(Color.BLACK);
				else if (buttons[i][j].getText().equals("O"))
					buttons[i][j].setBackground(Color.WHITE);
				else if (buttons[i][j].getText().equals("."))
					buttons[i][j].setBackground(Color.LIGHT_GRAY);
			}
			panel.setVisible(true);
		}

		add(panel);

		setTitle("Othello");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (buttons[i][j] == e.getSource()) {
					if (humansTurn(i, j)) {
						computersTurn();
					}
				}
			}
		}
	}

	public boolean humansTurn(int i, int j) {
		boolean hasPlayed = false;
		if (this.game.humansTurn(i, j))
			hasPlayed = true;
		setBoard(game.getBoard());
		this.printBoardGUI();
		if (game.gameOver()) {
			System.out.println("The game has ended");
			System.out.println(game.announceResult());
		}
		if (!game.humanCanMove() && !game.gameOver()) {
			System.out.println("You can't move! So it's the AI's turn now");
		}

		return hasPlayed;
	}

	public void computersTurn() {
		game.computersTurn();
		setBoard(game.getBoard());
		this.printBoardGUI();

		if (game.gameOver()) {
			System.out.println("The game has ended. ");
			System.out.println(game.announceResult());
		}

	}

	public void printBoardGUI() {
		for (short i = 0; i < 8; i++) {
			for (short j = 0; j < 8; j++) {
				Coin piece = board.getPeice(new Point(i, j));
				if (piece != Coin.empty)
					buttons[i][j].setText((piece == Coin.white) ? "O" : "X");
				if (buttons[i][j].getText().equals("X"))
					buttons[i][j].setBackground(Color.BLACK);
				else if (buttons[i][j].getText().equals("O"))
					buttons[i][j].setBackground(Color.WHITE);
			}
		}
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIBoard();
			}
		});
	}
}
