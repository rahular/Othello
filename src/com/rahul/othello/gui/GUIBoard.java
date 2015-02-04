package com.rahul.othello.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.rahul.othello.Board;
import com.rahul.othello.Point;
import com.rahul.othello.players.IdealPlayer;
import com.rahul.othello.players.RandomPlayer;
import com.rahul.othello.players.SequentialPlayer;
import com.rahul.othello.util.Coin;

public class GUIBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel boardPanel;
	private JButton[][] buttons;
	private Board board;
	private GUIGame game;
	private GUIConsole console;
	private GUIConfig config;
	private PlayerType computerPlayerType;

	private Coin humanPlayerColor, computerPlayerColor;

	private int currentX, currentY;

	public GUIBoard(GUIConsole console, GUIConfig config) {
		this.console = console;
		this.config = config;
		configure();
		console.addLine(config.toString());

		this.setBoard(game.getBoard());
		initUI();		

		if(computerPlayerColor == Coin.white) 
			computersTurn();
		
		this.setVisible(true);
	}

	private void configure() {
		humanPlayerColor = config.getHumanPlayer();
		computerPlayerColor = humanPlayerColor.change();
		computerPlayerType = config.getPlayerType();

		if (computerPlayerType == PlayerType.IdealPlayer)
			game = new GUIGame(new IdealPlayer(computerPlayerColor,
					config.getDifficultyLevel(), config.getAlgorithm()));
		else if (computerPlayerType == PlayerType.RandomPlayer)
			game = new GUIGame(new RandomPlayer(computerPlayerColor));
		else
			game = new GUIGame(new SequentialPlayer(computerPlayerColor));
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
				Coin piece = board.getPiece(new Point(i, j));
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

		this.console.setLocation(this.getX() + 600, this.getY());
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

	@SuppressWarnings("unused")
	private void fakeSleep() {
		Random random = new Random();
		int n = 3000;
		long bits, val;

		do {
			bits = (random.nextLong() << 1) >>> 1;
			val = bits % n;
		} while (bits - val + (n - 1) < 0L);

		try {
			Thread.sleep(val);
		} catch (Exception e) {
		}
	}

	private boolean humansTurn(int i, int j) {
		if (game.gameOver()) {
			console.addLine("The game has ended");
			console.addLine(game.announceResult());
		}

		boolean hasPlayed = false;
		Point nextMove = new Point((short) i, (short) j);
		if (this.game.humansTurn(humanPlayerColor, nextMove))
			hasPlayed = true;
		setBoard(game.getBoard());
		this.printBoardGUI();
		if (hasPlayed) {
			console.append(nextMove.toString());
			currentX = i;
			currentY = j;
		}
		return hasPlayed;
	}

	private void computersTurn() {
		if (game.gameOver()) {
			console.addLine("The game has ended.");
			console.addLine(game.announceResult());
		}
		
		Point nextMove = game.computersTurn(computerPlayerColor);
		setBoard(game.getBoard());
		try {
			console.append(nextMove.toString());
			currentX = nextMove.getX();
			currentY = nextMove.getY();
		} catch (Exception e) {
		}

		this.printBoardGUI();
	}

	private void printBoardGUI() {
		for (short i = 0; i < 8; i++) {
			for (short j = 0; j < 8; j++) {
				Coin piece = board.getPiece(new Point(i, j));
				if (piece != Coin.empty)
					buttons[i][j].setText((piece == Coin.white) ? "O" : "X");
				if (buttons[i][j].getText().equals("X"))
					buttons[i][j].setBackground(Color.BLACK);
				else if (buttons[i][j].getText().equals("O"))
					buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setBorder(null);
			}
		}
		buttons[currentX][currentY].setBorder(new LineBorder(Color.RED, 4));
	}
}
