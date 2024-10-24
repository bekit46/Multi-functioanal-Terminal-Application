import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * to be added:
 * tictactoe player names? print the winner in ascii art
 * terminating the program/closing message in ascii art
 */

public class Project1
{
    /**
     * This function includes main menu of the application. It consists of 4 different sub menu and each sub menu divides into sub functions.
     */
    public static void main(String args[])
    {
        String input;
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        art("welcome".toUpperCase(),true,scanner);
        while(true)
        {
            System.out.println("[A] Array Operations Menu ");
            System.out.println("[B] Matrix Operations Menu ");
            System.out.println("[C] Text Encription Menu ");
            System.out.println("[D] Tic-Tac-Toe Game");
            System.out.println("[E] Exit the program");
            System.out.printf("Make your selection: ");

            input = scanner.nextLine().toUpperCase();

            switch(input)
            {
                case "A":
                    FunctionA(scanner);
                    clearConsole();
                    break;
                case "B":
                    clearConsole();
                    FunctionB();
                    break;
                case "C":
                    FunctionC(scanner);
                    clearConsole();
                    break;
                case "D":
                    FunctionD(scanner);
                    clearConsole();
                    break;
                case "E":
                    clearConsole();
                    System.out.println("Application is shutting down...");
                    scanner.close();
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid entry: please press A, B, C, D (press E to shut down)");
            }
        }
    }

    //************************************OPTION A ALL FUNCTIONS****************************************************


    /**
     * 
     */
    public static void FunctionA(Scanner scanner)
    {
        int array_size = 0;
        double[] user_array;
        clearConsole();
        System.out.println("ARRAY OPERATIONS");

        while (true) 
        {
            System.out.print("Enter the size of the array (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) 
            {
                scanner.nextLine();
                clearConsole();
                return;
            }
            if (input.matches("\\d+"))
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
                    System.out.println("Error: Array's size must be a non-negative number!");
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

        for (int i = 0; i < array_size; i++) 
        {

            while (true) 
            {
                System.out.print("Enter element " + (i + 1) + " (or X to exit): ");
                String elementInput = scanner.next().trim().toUpperCase();

                if (elementInput.equals("X")) 
                {
                    scanner.nextLine();
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
        System.out.println("ARRAY OPERATIONS");
        printarr(user_array);
        System.out.println();
        System.out.printf("Aritmetic mean: %.4f\n" , aritmetic_mean(array_size, user_array));
        System.out.printf("Geometric mean: %.4f\n" , geometric_mean(array_size, user_array));
        System.out.printf("Harmonic mean:  %.4f\n" , harmonic_mean(array_size, user_array, 0, 0));
        System.out.printf("Median:         %.4f\n" , median(array_size, user_array));
        scanner.nextLine();
        System.out.println("");
        System.out.println("Press enter to return to the main menu ");
        scanner.nextLine();
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

    public static void FunctionC(Scanner scanner){
        
        clearConsole();
        
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

            if(scanner.hasNextInt()){//check if the input is a number
                choice = scanner.nextInt();//keep the number that user provided
                if(choice==1||choice==2||choice==3){//check if the number taken is valid
                    if(choice==3){//if return to the main menu option is selected
                        scanner.nextLine();
                        return;//stop and return to main menu
                    }
                    if(choice==2){
                        selected="Decryption";//update the string
                    }
                    clearConsole();
                    System.out.println("TEXT ENCRYPTION/DECRYPTION");
                    System.out.printf("You have selected %s\n",selected);
                    System.out.println("Please enter a key between the range [-26, 26]");
                    if(scanner.hasNextInt()){//check if the input is a number
                        key = scanner.nextInt();//keep the number that user provided
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
                        scanner.next();//clear the scanner object to get the next input without any problems
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
                scanner.next();//clear the scanner object to get the next input without any problems
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

        scanner.nextLine();//after taking integer values as inputs, use nextLine() to clean '\n' character
        System.out.printf("enter the message to be %s:\n",selected);//ask the message to be processed
        String message = scanner.nextLine();//get the string

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
        scanner.nextLine();
    }

    //************************************OPTION D ALL FUNCTIONS****************************************************

    public static void FunctionD(Scanner scanner)
    {
        clearConsole();
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

            System.out.println("Type 'y' if you want to play again: ");
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

    public static void art(String input,boolean opening,Scanner scanner){
        boolean animation = true;
            
            String[] A = {          "   ###    " ,                                  
                                    "  ## ##   " ,                                  
                                    " ##   ##  " ,                                  
                                    "##     ## " ,                                  
                                    "######### " ,                                  
                                    "##     ## " ,                                  
                                    "##     ## "};
        
            String[] B = {          "########  " ,                                  
                                    "##     ## " ,                                  
                                    "##     ## " ,                                  
                                    "########  " ,                                  
                                    "##     ## " ,                                  
                                    "##     ## " ,                                  
                                    "########  "};
        
            String[] C = {          " ######  " , 
                                    "##    ## " , 
                                    "##       " , 
                                    "##       " , 
                                    "##       " , 
                                    "##    ## " , 
                                    " ######  "};
                   
            String[] D = {          "########  " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "########  "};
        
            String[] E = {          "######## " ,
                                    "##       " ,                                    
                                    "##       " ,                                    
                                    "######   " ,                                    
                                    "##       " ,                                    
                                    "##       " ,                                  
                                    "######## "};
        
            String[] F = {          "######## " , 
                                    "##       " , 
                                    "##       " , 
                                    "######   " , 
                                    "##       " , 
                                    "##       " , 
                                    "##       "};
        
            String[] G = {          " ######   " , 
                                    "##    ##  " , 
                                    "##        " , 
                                    "##   #### " , 
                                    "##    ##  " , 
                                    "##    ##  " , 
                                    " ######   "};
                 
            String[] H = {          "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "######### " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## "};
        
            String[] I = {          "#### " , 
                                    " ##  " , 
                                    " ##  " , 
                                    " ##  " , 
                                    " ##  " , 
                                    " ##  " , 
                                    "#### "};
                  
            String[] J = {          "      ## " , 
                                    "      ## " , 
                                    "      ## " , 
                                    "      ## " , 
                                    "##    ## " , 
                                    "##    ## " , 
                                    " ######  "};
        
            String[] K = {          "##    ## " , 
                                    "##   ##  " , 
                                    "##  ##   " , 
                                    "#####    " , 
                                    "##  ##   " , 
                                    "##   ##  " , 
                                    "##    ## "};
        
            String[] L = {          "##       " , 
                                    "##       " , 
                                    "##       " , 
                                    "##       " , 
                                    "##       " , 
                                    "##       " , 
                                    "######## "};
        
            String[] M = {          "##     ## " , 
                                    "###   ### " , 
                                    "#### #### " , 
                                    "## ### ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## "};
        
            String[] N = {          "##    ## " , 
                                    "###   ## " , 
                                    "####  ## " , 
                                    "## ## ## " , 
                                    "##  #### " , 
                                    "##   ### " , 
                                    "##    ## "};
        
            String[] O = {          " #######  " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    " #######  "};
                   
            String[] P = {          "########  " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "########  " , 
                                    "##        " , 
                                    "##        " , 
                                    "##        "};

            String[] Q = {          " #######  " ,
                                    "##     ## " ,
                                    "##     ## " ,
                                    "##     ## " , 
                                    "##  ## ## " , 
                                    "##    ##  " , 
                                    " ##### ## "};
        
            String[] R = {          "########  " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "########  " , 
                                    "##   ##   " , 
                                    "##    ##  " , 
                                    "##     ## "};
        
            String[] S = {          " ######  " , 
                                    "##    ## " , 
                                    "##       " , 
                                    " ######  " , 
                                    "      ## " , 
                                    "##    ## " , 
                                    " ######  "};
                  
            String[] T = {          "######## " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    "};
        
            String[] U = {          "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    " #######  "};
                
            String[] V = {          "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    "##     ## " , 
                                    " ##   ##  " , 
                                    "  ## ##   " , 
                                    "   ###    "};
        
            String[] W = {          "##      ## " , 
                                    "##  ##  ## " , 
                                    "##  ##  ## " , 
                                    "##  ##  ## " , 
                                    "##  ##  ## " , 
                                    "##  ##  ## " , 
                                    " ###  ###  "};
        
            String[] X = {          "##     ## " , 
                                    " ##   ##  " , 
                                    "  ## ##   " , 
                                    "   ###    " , 
                                    "  ## ##   " , 
                                    " ##   ##  " , 
                                    "##     ## "};
        
            String[] Y = {          "##    ## " , 
                                    " ##  ##  " , 
                                    "  ####   " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    " , 
                                    "   ##    "};
        
            String[] Z = {          "######## " , 
                                    "     ##  " , 
                                    "    ##   " , 
                                    "   ##    " , 
                                    "  ##     " , 
                                    " ##      " , 
                                    "######## "};

            String[] space = {      "    " ,
                                    "    " ,
                                    "    " ,
                                    "    " ,
                                    "    " ,
                                    "    " ,
                                    "    "};

            String[] one = {    "   ##   " , 
                                " ####   " , 
                                "   ##   " , 
                                "   ##   " , 
                                "   ##   " , 
                                "   ##   " , 
                                " ###### "};

            String[] two = {    " #######  " ,
                                "##     ## " ,
                                "       ## " ,
                                " #######  " ,
                                "##        " ,
                                "##        " ,
                                "######### "};

            String[] three = {  " #######  " ,
                                "##     ## " ,
                                "       ## " ,
                                " #######  " ,
                                "       ## " ,
                                "##     ## " ,
                                " #######  "};

            String[] four = {   "##        " ,
                                "##    ##  " ,
                                "##    ##  " ,
                                "##    ##  " ,
                                "######### " ,
                                "      ##  " ,
                                "      ##  "};

            String[] five = {   "######## " ,
                                "##       " ,
                                "##       " ,
                                "#######  " ,
                                "      ## " ,
                                "##    ## " ,
                                " ######  "};

            String[] six = {    " #######  " ,
                                "##     ## " ,
                                "##        " ,
                                "########  " ,
                                "##     ## " ,
                                "##     ## " ,
                                " #######  "};
                        
            String[] seven = {  "######## " ,
                                "##    ## " ,
                                "    ##   " ,
                                "   ##    " ,
                                "  ##     " ,
                                "  ##     " ,
                                "  ##     "};

            String[] eight = {  " #######  " ,
                                "##     ## " ,
                                "##     ## " ,
                                " #######  " ,
                                "##     ## " ,
                                "##     ## " ,
                                " #######  "};

            String[] nine = {   " #######  " ,
                                "##     ## " ,
                                "##     ## " ,
                                " ######## " ,
                                "       ## " ,
                                "##     ## " ,
                                " #######  "};

            String[] zero = {   "  #####   " ,
                                " ##   ##  " ,
                                "##     ## " ,
                                "##     ## " ,
                                "##     ## " ,
                                " ##   ##  " ,
                                "  #####   "};
            
            String[] excMark = {"#### " , 
                                "#### " , 
                                "#### " , 
                                " ##  " , 
                                "     " , 
                                "#### " , 
                                "#### "};
            
            String[] nonchar = {"        " ,
                                "        " ,
                                "        " ,
                                "####### " ,
                                "        " ,
                                "        " ,
                                "        "};

            String[] dot = {    "    " ,
                                "    " ,
                                "    " ,
                                "    " ,
                                "    " ,
                                "### " ,
                                "### "};

            ArrayList<String[]> message = new ArrayList<>();
            for(char c:input.toCharArray()){
                switch(c){
                    case 'A':
                        message.add(A);
                        break;
                    case 'B':
                        message.add(B);
                        break;
                    case 'C':
                        message.add(C);
                        break;
                    case 'Ç':
                        message.add(C);
                        break;
                    case 'D':
                        message.add(D);
                        break;
                    case 'E':
                        message.add(E);
                        break;
                    case 'F':
                        message.add(F);
                        break;
                    case 'G':
                        message.add(G);
                        break;
                    case 'Ğ':
                        message.add(G);
                        break;
                    case 'H':
                        message.add(H);
                        break;
                    case 'I':
                        message.add(I);
                        break;
                    case 'İ':
                        message.add(I);
                        break;
                    case 'J':
                        message.add(J);
                        break;
                    case 'K':
                        message.add(K);
                        break;
                    case 'L':
                        message.add(L);
                        break;
                    case 'M':
                        message.add(M);
                        break;
                    case 'N':
                        message.add(N);
                        break;
                    case 'O':
                        message.add(O);
                        break;
                    case 'Ö':
                        message.add(O);
                        break;
                    case 'P':
                        message.add(P);
                        break;
                    case 'Q':
                        message.add(Q);
                        break;
                    case 'R':
                        message.add(R);
                        break;
                    case 'S':
                        message.add(S);
                        break;
                    case 'Ş':
                        message.add(S);
                        break;
                    case 'T':
                        message.add(T);
                        break;
                    case 'U':
                        message.add(U);
                        break;
                    case 'Ü':
                        message.add(U);
                        break;
                    case 'V':
                        message.add(V);
                        break;
                    case 'W':
                        message.add(W);
                        break;
                    case 'X':
                        message.add(X);
                        break;
                    case 'Y':
                        message.add(Y);
                        break;
                    case 'Z':
                        message.add(Z);
                        break;
                    case ' ':
                        message.add(space);
                        break;
                    case '1':
                        message.add(one);
                        break;
                    case '2':
                        message.add(two);
                        break;
                    case '3':
                        message.add(three);
                        break;
                    case '4':
                        message.add(four);
                        break;
                    case '5':
                        message.add(five);
                        break;
                    case '6':
                        message.add(six);
                        break;
                    case '7':
                        message.add(seven);
                        break;
                    case '8':
                        message.add(eight);
                        break;
                    case '9':
                        message.add(nine);
                        break;
                    case '0':
                        message.add(zero);
                        break;
                    case '!':
                        message.add(excMark);
                        break;
                    case '.':
                        message.add(dot);
                        break;
                    default:
                        message.add(nonchar);
                        break;
                }
            }
                                            



        String[][] letters = {space,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z};
    
        int[] pointers = new int[input.length()];
        int currentpos = 0;

        //for the opening part
        if(opening&&animation){
            while(true){
                clearConsole();
        
                for(int i = 0;i<7;i++){//row of a letter
                    for(int j = 0;j<=currentpos;j++){//each letter
                        System.out.print(letters[pointers[j]][i]);
                    }
                    System.out.print("\n");
                }

                if(letters[pointers[currentpos]]!=message.get(currentpos))
                    pointers[currentpos]++;
                else    
                    currentpos++;
                if(currentpos==pointers.length){
                    break;
                }

                System.out.print("\n");
                try{
                    Thread.sleep(70);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                
            }
        
            //blink?
            for(int blink = 0;blink<4;blink++){
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                clearConsole();
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                for(int i = 0;i<7;i++){
                    for(int j = 0;j<message.size();j++){
                        System.out.print(message.get(j)[i]);
                    }
                    System.out.print("\n");
                }
            }  

            String[] array = {"   _____ _____   ____  _    _ _____    __ _____                    \n" ,
                        "  / ____|  __ \\ / __ \\| |  | |  __ \\  /_ | ____|                   \n" ,
                        " | |  __| |__) | |  | | |  | | |__) |  | | |__                     \n" ,
                        " | | |_ |  _  /| |  | | |  | |  ___/   | |___ \\                    \n" ,
                        " | |__| | | \\ \\| |__| | |__| | |       | |___) |                   \n" ,
                        "  \\_____|_|  \\_\\\\____/ \\____/|_|       |_|____/                    \n" ,
                        "  ______ ______ ______ ______ ______ ______ ______ ______ ______   \n" ,
                        " |______|______|______|______|______|______|______|______|______|  \n" ,
                        "     /\\           | |       \\ \\   / (_) (_) |           | |        \n" ,
                        "    /  \\   _ __ __| | __ _   \\ \\_/ / _   _| | _____  ___| |        \n" ,
                        "   / /\\ \\ | '__/ _` |/ _` |   \\   / | | | | |/ / __|/ _ \\ |        \n" ,
                        "  / ____ \\| | | (_| | (_| |    | |  | |_| |   <\\__ \\  __/ |        \n" ,
                        " /_/___ \\_\\_|  \\__,_|\\__,_|    |_| _ \\__,_|_|\\_\\___/\\___|_|   _    \n" ,
                        " |  __ \\(_) |                 (_)_(_)         (_) (_)        | |   \n" ,
                        " | |  | |_| | __ _ _ __ __ _   / _ \\ _____   _ _   _ _ __ ___| | __\n" ,
                        " | |  | | | |/ _` | '__/ _` | | | | |_  / | | | | | | '__/ _ \\ |/ /\n" ,
                        " | |__| | | | (_| | | | (_| | | |_| |/ /| |_| | |_| | | |  __/   < \n" ,
                        " |_____/|_|_|\\__,_|_|  \\__,_|  \\___//___|\\__, |\\__,_|_|  \\___|_|\\_\\\n" ,
                        "  ______    _   _ _        _____ _   _ _  __/ |                    \n" ,
                        " |  ____|  | | (_) |      / ____(_) (_) ||___/                     \n" ,
                        " | |__ __ _| |_ _| |__   | |  __  ___ | | __ _  ___                \n" ,
                        " |  __/ _` | __| | '_ \\  | | |_ |/ _ \\| |/ _` |/ _ \\               \n" ,
                        " | | | (_| | |_| | | | | | |__| | (_) | | (_| |  __/               \n" ,
                        " |_|  \\__,_|\\__|_|_| |_|  \\_____|\\___/|_|\\__, |\\___|               \n" ,
                        "                                          __/ |                    \n" ,
                        "  _   _       _    _   _            _    |___/                     \n" ,
                        " (_)_(_)     | |  (_) (_)     /\\   | |     | |                     \n" ,
                        "  / _ \\ _   _| | ___   _     /  \\  | | __ _| |__   __ _ ___        \n" ,
                        " | | | | | | | |/ / | | |   / /\\ \\ | |/ _` | '_ \\ / _` / __|       \n" ,
                        " | |_| | |_| |   <| |_| |  / ____ \\| | (_| | |_) | (_| \\__ \\       \n" ,
                        "  \\___/ \\__, |_|\\_\\\\__,_| /_/    \\_\\_|\\__,_|_.__/ \\__,_|___/       \n" ,
                        "  _    _ __/ |            _                 ____       _)_) _ _    \n" ,
                        " | |  | |___/            | |               |  _ \\     | |  (_) |   \n" ,
                        " | |  | | __ _ _   _ _ __| | ____ _ _ __   | |_) | ___| | ___| |_  \n" ,
                        " | |  | |/ _` | | | | '__| |/ / _` | '_ \\  |  _ < / _ \\ |/ / | __| \n" ,
                        " | |__| | (_| | |_| | |  |   < (_| | | | | | |_) |  __/   <| | |_  \n" ,
                        "  \\____/ \\__, |\\__,_|_|  |_|\\_\\__,_|_| |_| |____/ \\___|_|\\_\\_|\\__| \n" ,
                        "          __/ |                                                    \n" ,
                        "         |___/                                                     \n"};
                    
            for(int i = 0;i<array.length;i++){
                clearConsole();
                for(int j = 0;j<=i;j++){
                    System.out.print(array[j]);
                }
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            
            System.out.print("\n\nPress enter to move to the main menu ");
            scanner.nextLine();
            clearConsole();
            for(int i = array.length-1;i>=0;i--){
                for(int j = 0;j<=i;j++){
                    System.out.print(array[j]);
                }
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                clearConsole();
            }

        }
        //without animation, for all other word prints
        if(!opening){
            for(int i = 0;i<7;i++){
                for(int j = 0;j<message.size();j++){
                    System.out.print(message.get(j)[i]);
                }
                System.out.print("\n");
            }
        }
        //opening without any animation
        if(opening&&!animation){
            for(int i = 0;i<7;i++){
                for(int j = 0;j<message.size();j++){
                    System.out.print(message.get(j)[i]);
                }
                System.out.print("\n");
            }
            System.out.print("   _____ _____   ____  _    _ _____    __ _____                    \n" +
                        "  / ____|  __ \\ / __ \\| |  | |  __ \\  /_ | ____|                   \n" +
                        " | |  __| |__) | |  | | |  | | |__) |  | | |__                     \n" +
                        " | | |_ |  _  /| |  | | |  | |  ___/   | |___ \\                    \n" +
                        " | |__| | | \\ \\| |__| | |__| | |       | |___) |                   \n" +
                        "  \\_____|_|  \\_\\\\____/ \\____/|_|       |_|____/                    \n" +
                        "  ______ ______ ______ ______ ______ ______ ______ ______ ______   \n" +
                        " |______|______|______|______|______|______|______|______|______|  \n" +
                        "     /\\           | |       \\ \\   / (_) (_) |           | |        \n" +
                        "    /  \\   _ __ __| | __ _   \\ \\_/ / _   _| | _____  ___| |        \n" +
                        "   / /\\ \\ | '__/ _` |/ _` |   \\   / | | | | |/ / __|/ _ \\ |        \n" +
                        "  / ____ \\| | | (_| | (_| |    | |  | |_| |   <\\__ \\  __/ |        \n" +
                        " /_/___ \\_\\_|  \\__,_|\\__,_|    |_| _ \\__,_|_|\\_\\___/\\___|_|   _    \n" +
                        " |  __ \\(_) |                 (_)_(_)         (_) (_)        | |   \n" +
                        " | |  | |_| | __ _ _ __ __ _   / _ \\ _____   _ _   _ _ __ ___| | __\n" +
                        " | |  | | | |/ _` | '__/ _` | | | | |_  / | | | | | | '__/ _ \\ |/ /\n" +
                        " | |__| | | | (_| | | | (_| | | |_| |/ /| |_| | |_| | | |  __/   < \n" +
                        " |_____/|_|_|\\__,_|_|  \\__,_|  \\___//___|\\__, |\\__,_|_|  \\___|_|\\_\\\n" +
                        "  ______    _   _ _        _____ _   _ _  __/ |                    \n" +
                        " |  ____|  | | (_) |      / ____(_) (_) ||___/                     \n" +
                        " | |__ __ _| |_ _| |__   | |  __  ___ | | __ _  ___                \n" +
                        " |  __/ _` | __| | '_ \\  | | |_ |/ _ \\| |/ _` |/ _ \\               \n" +
                        " | | | (_| | |_| | | | | | |__| | (_) | | (_| |  __/               \n" +
                        " |_|  \\__,_|\\__|_|_| |_|  \\_____|\\___/|_|\\__, |\\___|               \n" +
                        "                                          __/ |                    \n" +
                        "  _   _       _    _   _            _    |___/                     \n" +
                        " (_)_(_)     | |  (_) (_)     /\\   | |     | |                     \n" +
                        "  / _ \\ _   _| | ___   _     /  \\  | | __ _| |__   __ _ ___        \n" +
                        " | | | | | | | |/ / | | |   / /\\ \\ | |/ _` | '_ \\ / _` / __|       \n" +
                        " | |_| | |_| |   <| |_| |  / ____ \\| | (_| | |_) | (_| \\__ \\       \n" +
                        "  \\___/ \\__, |_|\\_\\\\__,_| /_/    \\_\\_|\\__,_|_.__/ \\__,_|___/       \n" +
                        "  _    _ __/ |            _                 ____       _)_) _ _    \n" +
                        " | |  | |___/            | |               |  _ \\     | |  (_) |   \n" +
                        " | |  | | __ _ _   _ _ __| | ____ _ _ __   | |_) | ___| | ___| |_  \n" +
                        " | |  | |/ _` | | | | '__| |/ / _` | '_ \\  |  _ < / _ \\ |/ / | __| \n" +
                        " | |__| | (_| | |_| | |  |   < (_| | | | | | |_) |  __/   <| | |_  \n" +
                        "  \\____/ \\__, |\\__,_|_|  |_|\\_\\__,_|_| |_| |____/ \\___|_|\\_\\_|\\__| \n" +
                        "          __/ |                                                    \n" +
                        "         |___/                                                     ");
            System.out.print("\n\nPress enter to move to the main menu ");
            scanner.nextLine();
        }
    }
}

