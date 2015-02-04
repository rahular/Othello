/**
 * 
 */
package com.rahul.othello.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.rahul.othello.util.Coin;
import javax.swing.JButton;

/**
 * @author rahular
 * Feb 3, 2015
 */
public class GUIStarter implements ActionListener {

	private JFrame frame;
	private JRadioButton rdbtnWhite;
	private JRadioButton rdbtnBlack;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JRadioButton rdbtnMinimax;
	private JRadioButton rdbtnAlphaBeta;
	
	private GUIConfig config;
	private JButton btnPlay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIStarter window = new GUIStarter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIStarter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		config = new GUIConfig();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 295, 172);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Othello - Starter");
		
		JLabel lblPlayAs = new JLabel("Play as");
		lblPlayAs.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblPlayAs);
		
		rdbtnWhite = new JRadioButton("White");
		rdbtnWhite.addActionListener(this);
		rdbtnWhite.setSelected(true);
		rdbtnWhite.setBounds(106, 7, 61, 23);
		frame.getContentPane().add(rdbtnWhite);
		
		rdbtnBlack = new JRadioButton("Black");
		rdbtnBlack.addActionListener(this);
		rdbtnBlack.setBounds(169, 7, 109, 23);
		frame.getContentPane().add(rdbtnBlack);
		
		JLabel lblPlayAgainst = new JLabel("Play against");
		lblPlayAgainst.setBounds(10, 40, 71, 14);
		frame.getContentPane().add(lblPlayAgainst);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(com.rahul.othello.gui.PlayerType.values()));
		comboBox.setSelectedItem(PlayerType.SequentialPlayer);
		comboBox.addActionListener(this);
		comboBox.setBounds(116, 37, 141, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		lblAlgorithm.setBounds(10, 68, 46, 14);
		frame.getContentPane().add(lblAlgorithm);
		
		rdbtnMinimax = new JRadioButton("Minimax");
		rdbtnMinimax.addActionListener(this);
		rdbtnMinimax.setEnabled(false);
		rdbtnMinimax.setBounds(106, 64, 76, 23);
		frame.getContentPane().add(rdbtnMinimax);
		
		rdbtnAlphaBeta = new JRadioButton("Alpha Beta");
		rdbtnAlphaBeta.addActionListener(this);
		rdbtnAlphaBeta.setEnabled(false);
		rdbtnAlphaBeta.setSelected(true);
		rdbtnAlphaBeta.setBounds(184, 64, 109, 23);
		frame.getContentPane().add(rdbtnAlphaBeta);
		
		btnPlay = new JButton("Play!");
		btnPlay.addActionListener(this);
		btnPlay.setBounds(78, 94, 89, 23);
		frame.getContentPane().add(btnPlay);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(rdbtnWhite)) {
			rdbtnBlack.setSelected(false);
			config.setHumanPlayer(Coin.white);
		} else if(event.getSource().equals(rdbtnBlack)) {
			rdbtnWhite.setSelected(false);
			config.setHumanPlayer(Coin.black);
		} else if(event.getSource().equals(comboBox)) {
			config.setPlayerType((PlayerType) comboBox.getSelectedItem());
			if(config.getPlayerType() == PlayerType.IdealPlayer) {
				rdbtnAlphaBeta.setEnabled(true);
				rdbtnMinimax.setEnabled(true);
			} else {
				rdbtnAlphaBeta.setEnabled(false);
				rdbtnMinimax.setEnabled(false);
			}
		} else if(event.getSource().equals(rdbtnMinimax)) {
			rdbtnAlphaBeta.setSelected(false);
		} else if(event.getSource().equals(rdbtnAlphaBeta)) {
			rdbtnMinimax.setSelected(false);
		} else if(event.getSource().equals(btnPlay)) {
			startPlaying();
		}
	}

	private void startPlaying() {
		frame.setVisible(false);
        frame.dispose();
        new GUIBoard(new GUIConsole(), config);
	}
}
