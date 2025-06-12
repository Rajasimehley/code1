# code1
The board is shown using the char[] board array of size 42, representing a 7 columns by 6 rows grid. Each slot holds either a space ' ' when empty, or 'B' for Blue player, or 'R' for Red player.
The Scanner class is used to take user input for choosing the game mode, selecting columns for moves, and deciding whether to play again.
The variable mode stores the chosen game mode: 1 for Player vs Player, 2 for Player vs Random Computer, and 3 for Player vs Basic AI.
Boolean variables include playAgain, which keeps the main game loop running for multiple games; playerTurn, which tracks if it is Blue's (true) or Red's (false) turn; and gameEnded which controls the current game play loop.
Integer variables blueWins and redWins keep track of the number of wins for each player.
At the start of each game, the board array is cleared by setting all positions to space ' '.
The program asks the user to input the mode number and validates it is between 1 and 3.
During gameplay, the board is printed each turn by iterating through the board array and displaying characters in rows of 7.
If it is a human player's turn (mode 1 or mode > 1 and playerTurn is true), the program asks the player to enter a column number from 1 to 7. Input is validated to ensure the column is within range and not full.
For mode 2 (Player vs Random Computer), when it is the computer's turn, a random column is selected using Math.random(), checked for availability, and the move is placed.
For mode 3 (Player vs Basic AI), the AI chooses a column with simple logic.
When a valid column is chosen, the program finds the lowest empty row in that column by checking the board array from bottom to top and places the current player's symbol ('B' or 'R').
After each move, the program checks for a win by scanning horizontally, vertically, and diagonally for four consecutive same symbols. This is done by checking indexes in the array based on the board layout.
If a win is detected, gameEnded is set true and the winner is announced. The win count of the winning player is increased.
If the board is full without a winner, a tie is declared and gameEnded is set true.
After each turn, the playerTurn boolean is to switch between Blue and Red or the computer.
When a game ends, the program displays the total wins for Blue and Red players.
Finally, the program asks the user if they want to play again. If the answer is no, playAgain is set false to end the main loop.
