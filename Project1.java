import java.io.IOException;
import java.util.Scanner;

public class Project1
{
    public static void main(String args[])
    {
        String input;

        while(true)
        {
            //clearConsole();
            Scanner scanner = new Scanner(System.in);
            System.out.println("A = Array Operations Menu ");
            System.out.println("B = Matrix Operations Menu ");
            System.out.println("C = Text Encription Menu ");
            System.out.println("D = Tic-Tac-Toe Game");
            System.out.println("X = Exit the program");
            System.out.printf("Make your selection: ");

            input = scanner.nextLine().toUpperCase();

            switch(input)
            {
                case "A":
                    clearConsole();
                    FunctionA();
                    break;
                case "B":
                    clearConsole();
                    FunctionB();
                    break;
                case "C":
                    clearConsole();
                    FunctionC();
                    break;
                case "D":
                    clearConsole();
                    FunctionD(scanner);
                    break;
                case "X":
                    clearConsole();
                    System.out.println("You pressed X application is shutting down...");
                    scanner.close();
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid entry please press A, B, C, D (press X to shut down)");
            }
        }

    }

    public static void FunctionA()
    {
        System.out.println("Function A is called, Array Operation Menu is not available for now");
    }

    public static void FunctionB()
    {
        System.out.println("Function B is called, Matrix Operation Menu is not available for now");
    }

    public static void FunctionC()
    {
        System.out.println("Function C is called, Text Encription Menu is not available for now");
    }



    // TIC TAC TOE GAME FUNCTIONS*********************************************************************
    public static void FunctionD(Scanner scanner)
    {
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
        System.out.println("TIC-TAC-TOE GAME");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
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
    //END OF THE TIC TAC TOE GAME FUNCTIONS*********************************************************************


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
