import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Project1
{
    public static void main(String args[])
    {
        String input;

        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("A = Array Operations Menu ");
            System.out.println("B = Matrix Operations Menu ");
            System.out.println("C = Text Encription Menu ");
            System.out.println("D = Tic-Tac-Toe Game");
            System.out.println("E = Exit the program");
            System.out.printf("Make your selection: ");

            input = scanner.nextLine().toUpperCase();

            switch(input)
            {
                case "A":
                    FunctionA();
                    clearConsole();
                    break;
                case "B":
                    clearConsole();
                    FunctionB();
                    break;
                case "C":
                    FunctionC();
                    clearConsole();
                    break;
                case "D":
                    FunctionD();
                    clearConsole();
                    break;
                case "E":
                    clearConsole();
                    System.out.println("You pressed E application is shutting down...");
                    scanner.close();
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid entry please press A, B, C, D (press X to shut down)");
            }
        }
    }

    //************************************OPTION A ALL FUNCTIONS****************************************************

    public static void FunctionA()
    {
        int array_size = 0;
        double[] user_array;
        Scanner scanner = new Scanner(System.in);
        clearConsole();
        System.out.println("ARRAY OPERATIONS");

        while (true) 
        {
            System.out.print("Enter the size of the array (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) 
            {
                clearConsole();
                return;
            }
            if (isNumeric(input)) 
            {
                array_size = Integer.parseInt(input);

                if (array_size > 0) 
                {
                    break; 
                } 
                else 
                {
                    clearConsole();
                    System.out.println("ARRAY OPERATIONS");
                    System.out.println("Error: " + input + " is not greater than 0. Please enter a size greater than 0!");
                }
            } 
            else 
            {
                clearConsole();
                System.out.println("ARRAY OPERATIONS");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        user_array = new double[array_size];
        clearConsole();
        System.out.println("ARRAY OPERATIONS");

        // Kullanıcıdan dizi elemanlarını al
        for (int i = 0; i < array_size; i++) 
        {
            while (true) 
            {
                System.out.print("Enter element " + (i + 1) + " (or X to exit): ");
                String elementInput = scanner.next().trim().toUpperCase();

                if (elementInput.equals("X")) 
                {
                    clearConsole();
                    return;
                }
                if (isNumeric(elementInput)) 
                { 
                    user_array[i] = Double.parseDouble(elementInput);
                    clearConsole();
                    System.out.println("ARRAY OPERATIONS");
                    break;
                } 
                else 
                {
                    clearConsole();
                    System.out.println("ARRAY OPERATIONS");
                    System.out.println("Error: Please enter a valid number!");
                }
            }
        }

        clearConsole();
        printarr(user_array);
        System.out.println();
        System.out.printf("Aritmetic mean: %.4f\n" , aritmetic_mean(array_size, user_array));
        System.out.printf("Geometric mean: %.4f\n" , geometric_mean(array_size, user_array));
        System.out.printf("Harmonic mean:  %.4f\n" , harmonic_mean(array_size, user_array, 0, 0));
        System.out.printf("Median:         %.4f\n" , median(array_size, user_array));
        scanner.nextLine();
        System.out.println("");
        System.out.println("Press any character to return main menu: ");
        String input_exit = scanner.nextLine();
    }

    public static void printarr(double[] arr) 
    {
        System.out.print("array={");
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print((double) arr[i]);
            if (i < arr.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static double median(int arr_size, double arr[])
    {
        double answer;
        Arrays.sort(arr);
        if (arr_size % 2 == 0) 
        {
            answer = (arr[arr_size / 2 - 1] + arr[arr_size / 2]) / 2;
        } 
        else 
        {
            answer = arr[arr_size / 2];
        }
        return answer;
    }

    public static double aritmetic_mean(int arr_size, double arr[]) 
    {
        double sum = 0;
        for (int i = 0; i < arr_size; i++) 
        {
            sum += arr[i];
        }
        return sum / arr_size;
    }

    public static double geometric_mean(int arr_size, double arr[]) 
    {
        double product = 1;
        for (int i = 0; i < arr_size; i++) 
        {
            product *= arr[i];
        }
        return Math.pow(product, 1.0 / arr_size);
    }

    public static double harmonic_mean(int arr_size, double arr[], int index, float sum) 
    {
        sum += (float)1 / arr[index];
        if (index == arr_size - 1) 
        {
            return arr_size / sum;
        }
        return harmonic_mean(arr_size, arr, index+1, sum);
    }

    public static boolean isNumeric(String input) 
    {
        return input.matches("-?\\d+(\\.\\d+)?"); 
    }

    //************************************OPTION B ALL FUNCTIONS****************************************************

    public static void FunctionB()
    {
        System.out.println("Function B is called, Matrix Operation Menu is not available for now");
    }

    //************************************OPTION C ALL FUNCTIONS****************************************************

    public static void FunctionC(){
        
        clearConsole();
        
        Scanner input = new Scanner(System.in);//create scanner object
        int choice=0;//the choice of the submenu
        int key=0;//key value to be entered
        String selected="Encryption";//string to keep the operation user selected
        System.out.println("TEXT ENCRYPTION/DECRYPTION");
        while(true){//loop until the user inserts a valid input
            //print the options
            System.out.println("[1] Encryption");
            System.out.println("[2] Decryption");
            System.out.println("[3] Return to the Main Menu");
            System.out.println("Choose one of the operations (1,2,3):");

            if(input.hasNextInt()){//check if the input is a number
                choice = input.nextInt();//keep the number that user provided
                if(choice==1||choice==2||choice==3){//check if the number taken is valid
                    if(choice==3){//if return to the main menu option is selected
                        return;//stop and return to main menu
                    }
                    if(choice==2){
                        selected="Decryption";//update the string
                    }
                    clearConsole();
                    System.out.println("TEXT ENCRYPTION/DECRYPTION");
                    System.out.printf("You have selected %s\n",selected);
                    System.out.println("Please enter a key between the range [-26, 26]");
                    if(input.hasNextInt()){//check if the input is a number
                        key = input.nextInt();//keep the number that user provided
                        if(key>=-26&&key<=26){//check if the key value is valid
                            clearConsole();
                            break;//end the loop
                        }
                        clearConsole();
                        System.out.println("TEXT ENCRYPTION/DECRYPTION");
                        System.out.println("Invalid input: The provided key is not in the range [-26, 26]");//display the error message
                        //return to the submenu
                    }
                    else{//if not a number
                        clearConsole();
                        System.out.println("TEXT ENCRYPTION/DECRYPTION");
                        System.out.println("Invalid input: The provided key is not a number");//display the error message
                        input.next();//clear the scanner object to get the next input without any problems
                        //return to the submenu
                    }
                }
                else{//if not a valid number
                    clearConsole();
                    System.out.println("TEXT ENCRYPTION/DECRYPTION");
                    System.out.printf("Invalid input: %d is not one of the options \n",choice);//display the error message
                }
            }
            else{//if not a number
                clearConsole();
                System.out.println("TEXT ENCRYPTION/DECRYPTION");
                System.out.println("Invalid input: The provided input is not a number");//display the error message
                input.next();//clear the scanner object to get the next input without any problems
            }
        }
        System.out.println("TEXT ENCRYPTION/DECRYPTION");
        int chosenkey = key;//to keep the key value that user selected because key might be change in the next operations
        System.out.println("You have selected " + selected + " with the key " + chosenkey);
        
        selected = "Encrypted";
        if(choice==2){//if decryption is selected
            key = key * -1;//change the key value to negative instead of checking the chosen operation in next lines
            selected="Decrypted";//update the string
        }

        input.nextLine();//after taking integer values as inputs, use nextLine() to clean '\n' character
        System.out.printf("enter the message to be %s:\n",selected);//ask the message to be processed
        String message = input.nextLine();//get the string

        String output = "";//to keep the characters after processing each one of them


        for(char character: message.toCharArray()){//for each character in the message
            //if the character gets shifted after 'z', it has to return to 'a'; and if it gets shifted to left after 'a',
            //it has to return to 'z'. To provide that, check after shifting and put the character back into its range
            if(character>='a'&&character<='z'){//if it is between 'a' and 'z'
                character += key;//shift the character key times
                if(character>'z')
                    character -= 26;//use 26, which is number of alphabetic characters, to make it correct
                if(character<'a')
                    character += 26;
            }
            else if(character>='A'&&character<='Z'){//if it is between 'A' and 'Z'
                character += key;
                if(character>'Z')
                    character -= 26;
                if(character<'A')
                    character += 26;
            }
            output += character;//add the character to the new string
        }
        clearConsole();
        System.out.println("TEXT ENCRYPTION/DECRYPTION");
        //operation is done, display the expected messages
        System.out.printf("key: %d \n",chosenkey);
        System.out.printf("message: %s \n",message);
        System.out.printf("%s message: %s\n\n",selected,output);

        System.out.println("Press enter to return to the main menu ");
        input.nextLine();
    }

    //************************************OPTION D ALL FUNCTIONS****************************************************

    public static void FunctionD()
    {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
            char currentPlayer = 'X';
            boolean gameWon = false;
            printBoard(board);

            while (!gameWon && !isBoardFull(board))
            {
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
                        printBoard(board);
                    } else {
                        clearConsole();
                        printBoard(board);
                        System.out.println("This cell is taken, please make a new selection.");
                    }
                } else {
                    clearConsole();
                    printBoard(board);
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






//************************************EXTRA FUNCTIONS****************************************************

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
