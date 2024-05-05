package TikTacToe;

import java.util.Scanner;

public class TikTacToeGame {
    private static final char EMPTY = '-';
    private static final char X = 'X';
    private static final char O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TikTacToeGame() {
        board = new char[3][3];
        currentPlayer = X;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            displayBoard();

            System.out.println("Player " + currentPlayer + "'s turn. Enter row (0-2) and column (0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (isWinner()) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a tie!");
                    break;
                }
                currentPlayer = (currentPlayer == X) ? O : X;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        scanner.close();
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }

    private boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY) ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void main(String[] args) {
        TikTacToeGame game = new TikTacToeGame();
        game.startGame();
    }
}
