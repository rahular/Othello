/**
 * 
 */
package com.rahul.othello.gui;

import com.rahul.othello.util.Algorithm;
import com.rahul.othello.util.Coin;

/**
 * @author rahular
 * Feb 3, 2015
 */
public class GUIConfig {
	private Coin humanPlayer;
	private Algorithm algorithm;
	private PlayerType playerType;
	/**
	 * @return the humanPlayer
	 */
	public Coin getHumanPlayer() {
		return humanPlayer;
	}
	/**
	 * @param humanPlayer the humanPlayer to set
	 */
	public void setHumanPlayer(Coin humanPlayer) {
		this.humanPlayer = humanPlayer;
	}
	/**
	 * @return the algorithm
	 */
	public Algorithm getAlgorithm() {
		return algorithm;
	}
	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
	/**
	 * @return the playerType
	 */
	public PlayerType getPlayerType() {
		return playerType;
	}
	/**
	 * @param playerType the playerType to set
	 */
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}
}

enum PlayerType {
	SequentialPlayer, RandomPlayer, IdealPlayer;
}

