import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 1):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            moves++;

            if (checkWinner(row, col)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean checkWinner(int row, int col) {
        // Check row
        if (board[row][0] == currentPlayer &&
            board[row][1] == currentPlayer &&
            board[row][2] == currentPlayer)
            return true;

        // Check column
        if (board[0][col] == currentPlayer &&
            board[1][col] == currentPlayer &&
            board[2][col] == currentPlayer)
            return true;

        // Check diagonals
        if (row == col &&
            board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (row + col == 2 &&
            board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }
}