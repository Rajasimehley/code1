import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] board = new char[42]; // 7 columns x 6 rows
        int mode = 0;
        boolean playAgain = true;
        int blueWins = 0; // count-Blue wins
        int redWins = 0; // count-Red wins
        while (playAgain) { // Setting up the board
            for (int i = 0; i < 42; i++) {
                board[i] = ' ';
            }
            // Select game mode
            System.out.println("Connect 4 Game Modes:");
            System.out.println("1.PLayer vs Player");
            System.out.println("2.Player vs Computer (Random)");
            System.out.println("3.Player vs Computer (Never loses)");
            mode = 0;
            while (mode < 1 || mode > 3) {
                System.out.println("Choose from mode (1-3): ");
                String input = scanner.nextLine();
                if (input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '3') {
                    mode = Integer.parseInt(input);
                } else {
                    System.out.println("Invalid input! Please enter 1, 2 or 3");
                }
                System.out.println("You are player blue!");
            }
            char playerSymbol = 'B'; // Blue - user
            char computerSymbol = 'R'; // Red - player 2 or computer
            boolean playerTurn = true; // true = blue
            boolean gameEnded = false;
            while (!gameEnded) {
                //Print board
                System.out.println();
                System.out.println(" 1 2 3 4 5 6 7");
                for (int row = 0; row < 6; row++) {
                    for (int column = 0; column < 7; column++) {
                        int index = row * 7 + column;
                        System.out.print("|" + board[index]);
                    }
                    System.out.println("|");
                }
                char currentPlayer = computerSymbol;
                if (playerTurn == true) {
                    currentPlayer = playerSymbol;
                }
                int chosenColumn = -1; // default as no column is chosen
                if (mode == 1 || (mode > 1 && playerTurn)) { // player's turn
                    boolean validMove = false;
                    while (!validMove) {
                        System.out.println("Scoreboard");
                        System.out.println("Blue wins!" + blueWins);
                        System.out.println("Red wins!" + redWins);
                        System.out.println("Player ");
                        if (playerTurn) {
                            System.out.println("Blue (B)");
                        } else {
                            System.out.println("Red (R)");
                        }
                        System.out.println("Choose column (1-7)");
                        String input = scanner.nextLine();
                        if (input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '7') {
                            chosenColumn = Integer.parseInt(input) - 1; // checking if column isn't full
                            boolean columnFull = true;
                            for (int r = 5; r >= 0; r--) {
                                int index = r * 7 + chosenColumn;
                                if (board[index] == ' ') {
                                    columnFull = false;
                                    break;
                                }
                            }
                            if (!columnFull) {
                                validMove = true;
                            } else {
                                System.out.println("Column is full! Please choose another.");
                            }
                        } else {
                            System.out.println("Invalid input! Enter from 1-7");
                        }
                    }
                } else {
                    System.out.println("Scoreboard");
                    System.out.println("Blue wins!" + blueWins);
                    System.out.println("Red wins!" + redWins);
                    if (mode == 2) {
                        boolean validMove = false;
                        while (!validMove) {
                            chosenColumn = (int) (Math.random() * (7-1)+1); // computer chooses
                            boolean columnFull = true;
                            for (int r = 5; r >= 0; r--) {
                                int index = r * 7 + chosenColumn;
                                if (board[index] == ' ') {
                                    columnFull = false;
                                    break;
                                }
                            }
                            if (!columnFull) {
                                validMove = true;
                            }
                        }
                        System.out.println("Computer chooses" + (chosenColumn + 1));
                    } else if (mode == 3) {
                        boolean moveMade = false;
                        for (int column = 0; column < 7 && !moveMade; column++) {
                            int row = 5;
                            while (row >= 0) {
                                int index = row * 7 + column;
                                if (board[index] == ' ') {
                                    break;
                                }
                                row--;
                            }
                            if (row >= 0) {
                                int index = row * 7 + column;
                                board[index] = computerSymbol;
                                boolean win = false;
                                int count = 0;
                                //horizontal check
                                count = 0;
                                for (int c = 0; c < 7; c++) {
                                    int i = row * 7 + c;
                                    if (board[i] == computerSymbol) {
                                        count++;
                                    } else {
                                        count = 0;
                                    }
                                    if (count >= 4) {
                                        win = true;
                                    }
                                }
                                // vertical check
                                if (!win) {
                                    count = 0;
                                    for (int r = 0; r < 6; r++) {
                                        int i = r * 7 + column;
                                        if (board[i] == computerSymbol) {
                                            count++;
                                        } else {
                                            count = 0;
                                        }
                                        if (count >= 4) {
                                            win = true;
                                        }
                                    }
                                }
                                // diagonal-down check
                                if (!win) {
                                    count = 0;
                                    while (row > 0 && column > 0) {
                                        row--;
                                        column--;
                                    }
                                    while (row < 6 && column < 7) {
                                        int i = row * 7 + column;
                                        if (board[i] == computerSymbol) {
                                            count++;
                                        } else {
                                            count = 0;
                                        }
                                        if (count >= 4) {
                                            win = true;
                                        }
                                        row++;
                                        column++;
                                    }
                                }
                                //diagonal-up check
                                count = 0;
                                for (int c = 3; c < 7; c++) {
                                    int i = row * 7 + c;
                                    if (board[i] == computerSymbol) {
                                        count++;
                                    } else {
                                        count = 0;
                                    }
                                    if (count >= 4) {
                                        win = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}