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
	private JPanel boardPanel;
	private JButton[][] buttons;
	private Board board;
	private GUIGame game;
	private GUIConsole console;

	public GUIBoard(GUIConsole console) {
		this.console = console;
		
		game = new GUIGame(null, new IdealPlayer(Coin.black, Difficulty.medium,
				Algorithm.alphaBeta));
		this.setBoard(game.getBoard());
		initUI();
		this.setVisible(true);
	}

	public GUIBoard(Board board) {
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	private void initUI() {
		boardPanel = new JPanel();

		boardPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		boardPanel.setLayout(new GridLayout(8, 8, 5, 5));

		this.buttons = new JButton[8][8];

		for (short i = 0; i < 8; i++) {
			for (short j = 0; j < 8; j++) {
				Coin piece = board.getPeice(new Point(i, j));
				if (piece != Coin.empty) {
					this.buttons[i][j] = new JButton(
							(piece == Coin.white) ? "O" : "X");
					boardPanel.add(this.buttons[i][j]);
				} else {
					this.buttons[i][j] = new JButton(".");
					boardPanel.add(this.buttons[i][j]);
				}
				buttons[i][j].addActionListener(this);
				if (buttons[i][j].getText().equals("X"))
					buttons[i][j].setBackground(Color.BLACK);
				else if (buttons[i][j].getText().equals("O"))
					buttons[i][j].setBackground(Color.WHITE);
				else if (buttons[i][j].getText().equals("."))
					buttons[i][j].setBackground(Color.LIGHT_GRAY);
			}
			boardPanel.setVisible(true);
		}

		add(boardPanel);

		setTitle("Othello");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setBoard(Board board) {
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

	private boolean humansTurn(int i, int j) {
		boolean hasPlayed = false;
		Point nextMove = new Point((short) i, (short) j);
		if (this.game.humansTurn(nextMove))
			hasPlayed = true;
		setBoard(game.getBoard());
		this.printBoardGUI();
		if (game.gameOver()) {
			console.addLine("The game has ended");
			console.addLine(game.announceResult());
		}
		if(hasPlayed) console.append(nextMove.toString());
		return hasPlayed;
	}

	private void computersTurn() {
		Point nextMove = game.computersTurn();
		setBoard(game.getBoard());
		this.printBoardGUI();
		
		console.append(nextMove.toString());
		if (game.gameOver()) {
			console.addLine("The game has ended. ");
			console.addLine(game.announceResult());
		}
	}

	private void printBoardGUI() {
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
				GUIConsole console = new GUIConsole();
				new GUIBoard(console);
			}
		});
	}
}
