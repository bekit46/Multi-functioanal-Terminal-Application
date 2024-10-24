import java.io.IOException;
import java.util.Scanner;

public class Function_D
{
    public static void main(String args[])
    {
        function_d();
    }

    public static void function_d()
    {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
            char currentPlayer = 'X';
            boolean gameWon = false;

            while (!gameWon && !isBoardFull(board)) {
                printBoard(board);
                System.out.printf("Player %s, enter your move (1-9) or press X to exit: ", currentPlayer);
                String input = scanner.nextLine().toUpperCase();

                if (input.equals("X")) {
                    System.out.println("You chose to exit the game.");
                    return;
                }

                if (input.matches("[1-9]")) {
                    int move = Integer.parseInt(input);
                    int row = (move - 1) / 3;
                    int col = (move - 1) % 3;

                    if (board[row][col] != 'X' && board[row][col] != 'O') {
                        board[row][col] = currentPlayer;
                        gameWon = checkWin(board, currentPlayer);
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        clearConsole();
                    } else {
                        printBoard(board);
                        clearConsole();
                        System.out.println("This cell is taken, please make a new selection.");
                    }
                } else {
                    printBoard(board);
                    clearConsole();
                    System.out.println("Invalid entry, please make a selection between 1 to 9.");
                }
            }

            clearConsole();
            printBoard(board);
            if (gameWon) {
                System.out.printf("Player %s wins!\n", (currentPlayer == 'X') ? 'O' : 'X');
            } else {
                System.out.println("It's a draw!");
            }

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (Y/N)");
            String choice = scanner.nextLine().toUpperCase();
            playAgain = choice.equals("Y");
            clearConsole();

        } while (playAgain);
    }

    public static void printBoard(char[][] board)
    {
        System.out.println("TIC - TAC - TOE GAME");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("   ");
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   -------------");
        }
    }

    public static boolean checkWin(char[][] board, char player)
    {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            return true;

        return false;
    }

    public static boolean isBoardFull(char[][] board)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] != 'X' && board[i][j] != 'O')
                    return false;
            }
        }
        return true;
    }

    public static void clearConsole() // clear the termianl
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}