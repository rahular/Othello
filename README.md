## Othello

### Aim
The ultimate aim of this project is to create an AI player for Othello.

### Design
See the [Design document](./design.md)

### Done
* Rules module
* Random Player
* Sequential Player
* Human Player
* `Board` class and other utils
* Ideal player (Not fully ideal.. Yet!)
* Minimax search
* Added `Difficulty` levels (`Difficulty.champion` is extremely slow)
* Evaluation function 

### TODO
* Create an ideal player (hard code the algorithm)
	- Implement a **better** evaluation function 
	- Implement Alpha-Beta pruning
* Collect data from the games of ideal player
* Create an AI player (preferably with ANN core)
* Train the AI
* Make GUI
