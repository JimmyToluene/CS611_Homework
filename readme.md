# <CS611_SlidingPuzzle_hw1>
---------------------------------------------------------------------------

## Files
---------------------------------------------------------------------------
GameBoard.java: This class is an abstract class, which will be extended by class SlidinggameBoard. It just defined some basic members and abstract method for future detail implementation.

SlidingPuzzleBoard.java: This class is a sub-class of Chessboard. Which realized parent’s methods and members. Also, it has its own methods and data members.

GameInput.java: This class is a functional class for handle I/O of this class.

GamePrompt.java: This class also is a functional class for store and print I/O prompt message.

GameActions.java: This class is a core part class in this project. It defines the rule of movement about this sliding game and also defines the game rules.
(In future this class will rewrite for more general usage)

Main.java: Main class of this project, which defines game rules and detailed flow of this game

## Notes
---------------------------------------------------------------------------
1. We use the polymorphism and inheritance features in this project. More detailly, the class relationship between GameBoard and SlidingPuzzleBoard is inheritance. And SlidingPuzzleBoard is a polymorphism of his base-class. This feature allows us in future fully reuse this project designs and class.

2.I adopt decoupling design idea in this project. Such as I create many tool classes, like classes GameInput and GamePrompt, it will help our future development be more easily and maximize the reuse of current classes.

3.The input methods are considered to handle not only valid input but also should handle some invalid or malicious inputs. This feature ensures this project robustness.

4.The class GameBoard enables create varies size board, like 3x3, 4x4.

5.The UI is user-friendly and some warning prompt colored for better display.


## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Make sure to be as thorough as possible!

Compile: javac -d out/CS611_SlidingPuzzle_hw1 src/*.java
Run: java out/CS611_SlidingPuzzle_hw1/Main

## Input/Output Example
---------------------------------------------------------------------------
🎉 WELCOME TO JIMMY'S SLIDING PUZZLE GAME!! 🎉
---------------------------------------------------------------------------------------------------------------------------
Enter chessboard size (>= 2): 2
---------------------------------------------------------------------------------------------------------------------------
SUCCESS! CURRENT CREATED BOARD SIZE IS: 2x2
----------------------------------------------------------------------------------
+---+---+
| 3 |   1 |
+---+---+
| 2 |       |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [2, 1]
1
----------------------------------------------------------------------------------
+---+---+
| 3 |      |
+---+---+
| 2 |   1 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [3, 1]
3
----------------------------------------------------------------------------------
+---+---+
|      | 3 |
+---+---+
| 2   | 1 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [3, 2]
2
----------------------------------------------------------------------------------
+---+---+
| 2   | 3 |
+---+---+
|      | 1 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [1, 2]
1
----------------------------------------------------------------------------------
+---+---+
| 2  |  3 |
+---+---+
| 1  |     |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [1, 3]
3
----------------------------------------------------------------------------------
+---+---+
| 2  |     |
+---+---+
| 1  |  3 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [2, 3]
2
----------------------------------------------------------------------------------
+---+---+
|     |  2 |
+---+---+
| 1  |  3 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [2, 1]
1
----------------------------------------------------------------------------------
+---+---+
| 1  |  2 |
+---+---+
|      | 3 |
+---+---+
----------------------------------------------------------------------------------
Player, which tile do you want to slide to the empty space?
Please enter a number. Valid: [3, 1]
3
🥳 YOU WIN!


