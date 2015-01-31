# Othello Design

## Aim

The aim of this project is to build an AI player capable of playing Othello after learning the game on its own. The only data given to the player will be logs of previously played games.

* **Input**: The board position
* **Output**: The next move

## Architecture

![Othello Architecture](./res/architecture.png?raw=true)

* **Player**: An interface which gets implemented by all player classes. (Helps comforming to a standard)
	- **Random Player**: A player which just moves randomly
	- **Sequential Player**: A player which places a coin in the first available legal position
	- **Human Player**: Takes input from the console
* **Coin**: An `enum` indicating whether a sqaure is empty, has a black or a white coin
* **Point**: Essentially represents a point(sqaure) on the board. Uniquely identified by `x` and `y` array co-ordinates
* **Board**: A class which holds the positional information of the coins along with data such as `turn to move`, etc
* **Rules**: (*Edit*: Integrated into the **Board class**) Holds the rule information for the game
* **Game**: A binder class which facilitates gameplay
* **Tournament**: A driver class for the entire program. Allows us to simulate a tournament of `n` games

## Work in progress

* **Ideal Player**: A player which never loses. (hard coded algorithm)
* **AI Player**: The player which is being built. (probably ConvNet)

## GUI

A simple GUI is built which looks like this.

![GUI Board Screenshot](./res/board.png?raw=true)

Any contributions to make it better is appreciated.
