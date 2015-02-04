/**
 * 
 */
package com.rahul.othello.gui;

import com.rahul.othello.util.Algorithm;
import com.rahul.othello.util.Coin;
import com.rahul.othello.util.Difficulty;

/**
 * @author rahular Feb 3, 2015
 */
public class GUIConfig {
	private Coin humanPlayer;
	private Algorithm algorithm;
	private PlayerType playerType;
	private int difficultyLevel;

	public GUIConfig() {
		setHumanPlayer(Coin.white);
		setPlayerType(PlayerType.SequentialPlayer);
	}

	/**
	 * @return the humanPlayer
	 */
	public Coin getHumanPlayer() {
		return humanPlayer;
	}

	/**
	 * @param humanPlayer
	 *            the humanPlayer to set
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
	 * @param algorithm
	 *            the algorithm to set
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
	 * @param playerType
	 *            the playerType to set
	 */
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	/**
	 * @return the difficultyLevel
	 */
	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel
	 *            the difficultyLevel to set
	 */
	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		if (difficultyLevel == DifficultyLevel.easy)
			this.difficultyLevel = Difficulty.easy;
		else if (difficultyLevel == DifficultyLevel.medium)
			this.difficultyLevel = Difficulty.medium;
		else if (difficultyLevel == DifficultyLevel.difficult)
			this.difficultyLevel = Difficulty.difficult;
		else
			this.difficultyLevel = Difficulty.champion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Human Player Color: " + humanPlayer + "\n");
		sb.append("Computer Player Type: " + playerType + "\n");
		if(playerType == PlayerType.IdealPlayer) {
			sb.append("Computer Algorithm: " + algorithm + "\n");
			sb.append("Computer difficulty: " + difficultyLevel + "\n");
		}
		return sb.toString();
	}
}

enum PlayerType {
	SequentialPlayer, RandomPlayer, IdealPlayer;
}

enum DifficultyLevel {
	easy, medium, difficult, champion;
}