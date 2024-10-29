import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Project1
{
    /**
     * The main entry point of the application that presents a menu for various operations.
     * It initializes the console, displays a welcome message with animation, and allows the user
     * to select different functionalities through a text-based menu. The program will continue to
     * run until the user chooses to exit.
     *
     * The menu offers the following options:
     * - A: Array Operations Menu
     * - B: Matrix Operations Menu
     * - C: Text Encryption Menu
     * - D: Tic-Tac-Toe Game
     * - E: Exit the program
     *
     * The user's input is validated, and an error message is displayed for invalid entries,
     * prompting the user to select a valid option again.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String args[])
    {
        String input;
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        boolean err = false;
        //art("welcome",true,scanner);
        while(true)
        {
            System.out.println("MAIN MENU");
            System.out.println("[A] Array Operations Menu ");
            System.out.println("[B] Matrix Operations Menu ");
            System.out.println("[C] Text Encription Menu ");
            System.out.println("[D] Tic-Tac-Toe Game");
            System.out.println("[E] Exit the program");
            if(err)
            {
                System.out.println("\nInvalid entry: please press A, B, C, D (press E to shut down)");
                err = false;
            }
            System.out.printf("Make your selection: ");
            

            input = scanner.nextLine().toUpperCase();

            switch(input)
            {
                case "A":
                    FunctionA(scanner);
                    clearConsole();
                    break;
                case "B":
                    FunctionB(scanner);
                    clearConsole();
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
                    err = true;
            }
        }
    }

//************************************OPTION A ALL FUNCTIONS****************************************************


    /**
     * Main function to execute array operations. It prompts the user for array size,
     * accepts user inputs for each element, and calculates statistical measures
     * (arithmetic mean, geometric mean, harmonic mean, and median) on the array.
     *
     * @param scanner The Scanner object for reading user input.
     */
    public static void FunctionA(Scanner scanner)
    {
        int array_size = 0;
        double[] user_array;
        clearConsole();
        System.out.println("ARRAY OPERATIONS");

        array_size = getSize(scanner, "Enter the size of the array (or X to exit): ", "ARRAY OPERATIONS", "ARRAY OPERATIONS");
        if(array_size == -1)
            return;

        user_array = new double[array_size];
        clearConsole();
        System.out.println("ARRAY OPERATIONS");

        for (int i = 0; i < array_size; i++) 
        {

            while (true) 
            {
                printarr(user_array);
                System.out.print("Enter element " + (i + 1) + " (or X to exit): ");
                String elementInput = scanner.next().trim().toUpperCase();

                if (elementInput.equals("X")) 
                {
                    scanner.nextLine();
                    clearConsole();
                    return;
                }
                if (elementInput.matches("-?\\d+(\\.\\d+)?")) 
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
                    System.out.println("Error: Please enter a valid number.");
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

    /**
     * Displays the array in a formatted table with borders.
     *
     * @param array The array of double values to be printed.
     */    
    public static void printarr(double[] array) {
        int maxLength = getMaxLength(array); // get max length number

        // Print the top border
        System.out.print("┌");
        for (int i = 0; i < array.length; i++) {
            System.out.print("──");
            System.out.print("─".repeat(maxLength));
            if (i < array.length - 1) System.out.print("┬");
        }
        System.out.println("┐");

        // Print the array elements with separators
        System.out.print("│");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%" + maxLength + ".2f  ", array[i]);
            System.out.print("│");
        }
        System.out.println();

        // Print the bottom border
        System.out.print("└");
        for (int i = 0; i < array.length; i++) {
            System.out.print("─".repeat(maxLength));
            System.out.print("──");
            if (i < array.length - 1) System.out.print("┴");
        }
        System.out.println("┘");
    }

    /**
     * Calculates the maximum length of array elements when formatted to two decimal places.
     * This is used to determine column width when printing the array.
     *
     * @param array The array of double values.
     * @return The maximum length as an integer.
     */
    private static int getMaxLength(double[] array) {
        int maxLength = 5; // Default width for values like "0.00"

        for (double value : array) {
            int length = String.format("%.2f", value).length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength + 1; // Adding 1 for padding
    }

    /**
     * Calculates the median of an array of double values.
     * If the array size is even, the median is the average of the two middle values.
     * Otherwise, it is the middle value.
     *
     * @param arr_size The size of the array.
     * @param arr      The array of double values.
     * @return The median value as a double.
     */
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

    /**
     * Calculates the arithmetic mean of an array of double values.
     *
     * @param arr_size The size of the array.
     * @param arr      The array of double values.
     * @return The arithmetic mean as a double.
     */
    public static double aritmetic_mean(int arr_size, double arr[]) 
    {
        double sum = 0;
        for (int i = 0; i < arr_size; i++) 
        {
            sum += arr[i];
        }
        return sum / arr_size;
    }

    /**
     * Calculates the geometric mean of an array of double values.
     *
     * @param arr_size The size of the array.
     * @param arr      The array of double values.
     * @return The geometric mean as a double.
     */
    public static double geometric_mean(int arr_size, double arr[]) 
    {
        double product = 1;
        for (int i = 0; i < arr_size; i++) 
        {
            product *= arr[i];
        }
        return Math.pow(product, 1.0 / arr_size);
    }

    /**
     * Recursively calculates the harmonic mean of an array of double values.
     *
     * @param arr_size The size of the array.
     * @param arr      The array of double values.
     * @param index    The current index in the array.
     * @param sum      The current cumulative sum for the harmonic mean calculation.
     * @return The harmonic mean as a double.
     */
    public static double harmonic_mean(int arr_size, double arr[], int index, float sum) 
    {
        sum += (float)1 / arr[index];
        if (index == arr_size - 1) 
        {
            return arr_size / sum;
        }
        return harmonic_mean(arr_size, arr, index+1, sum);
    }

//************************************OPTION B ALL FUNCTIONS****************************************************

    /**
     * Provides various matrix operations, including transposition, inversion,
     * matrix multiplication, and element-wise multiplication.
     * Displays a menu for users to select matrix operations.
     *
     * @param scanner Scanner for user input.
     */
    public static void FunctionB(Scanner scanner)
    {
        boolean exit = false;
        boolean err = false;
        
        while (!exit) {
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            System.out.println("[1] Transpose Matrix");
            System.out.println("[2] Inverse Matrix");
            System.out.println("[3] Matrix Multiplication");
            System.out.println("[4] Element-Wise Multiplication");
            System.out.println("[5] Exit");
            if(err)
            {
                System.out.println("\nInvalid choice. Please select a valid option.");
                err = false;
            }
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    transposeMatrix(scanner);
                    break;
                case "2":
                    inverseMatrix(scanner);
                    break;
                case "3":
                    matrixMultiplication(scanner);
                    break;
                case "4":
                    elementWiseMultiplication(scanner);
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    clearConsole();
                    err = true;
            }
        }
    }

    /**
     * Prompts the user to define a matrix by entering its dimensions and elements.
     * Allows the user to exit at any point by entering "X".
     *
     * @param scanner Scanner for user input.
     * @param operation The name of the matrix operation being performed (for display).
     * @return A 2D array representing the matrix or null if the user exits.
     */
    public static double[][] getMatrix(Scanner scanner,String operation)
    {
        int rows = 0;
        int cols = 0;
        
        // Satır sayısını al
        clearConsole();
        System.out.println("MATRIX OPERATIONS: "+operation);
        rows = getSize(scanner, "Enter the rows of the matrix (or X to exit): ", "MATRIX OPERATIONS: "+operation, "MATRIX OPERATIONS: "+operation);
        if(rows == -1)
            return null;

         // Sütun sayısını al
        clearConsole();
        System.out.println("MATRIX OPERATIONS: "+operation);
        cols = getSize(scanner, "Enter the columns of the matrix (or X to exit): ", "MATRIX OPERATIONS: "+operation, "MATRIX OPERATIONS: "+operation);
        if(cols == -1)
            return null;

        // Matrisi oluştur
        double[][] matrix = new double[rows][cols];
        boolean err = false;

        // Elemanları al
        clearConsole();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.println("MATRIX OPERATIONS: "+operation);
                    printMatrix(matrix);
                    if(err)
                    {
                        System.out.println("Error: Please enter a valid number.");
                        err = false;
                    }
                    System.out.print("Enter value for (" + (i + 1) + ", " + (j + 1) + ") element (or X to exit): ");
                    String elementInput = scanner.next().trim().toUpperCase();

                    if (elementInput.equals("X")) {
                        scanner.nextLine();
                        return null; // Çıkış
                    }

                    if (elementInput.matches("-?\\d+(\\.\\d+)?")) {
                        matrix[i][j] = Double.parseDouble(elementInput);
                        clearConsole();
                        break;
                    } else {
                        clearConsole();
                        err = true;
                    }
                }
            }
        }
        scanner.nextLine();
        return matrix;
    }

    /**
     * Creates a matrix with specified rows and columns and prompts the user to fill it with elements.
     *
     * @param row The number of rows in the matrix.
     * @param col The number of columns in the matrix.
     * @param scanner Scanner for user input.
     * @param operation The name of the matrix operation being performed (for title display).
     * @return A 2D array representing the matrix or null if the user exits.
     */
    public static double[][] getParamaterizedMatrix(int row, int col,Scanner scanner,String operation)
    {
        boolean err = false;
        double[][] matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                while (true) {
                    System.out.println("MATRIX OPERATIONS: "+operation);
                    printMatrix(matrix);
                    if(err)
                    {
                        System.out.println("Error: Please enter a valid number.");
                        err = false;
                    }
                    System.out.print("Enter value for (" + (i + 1) + ", " + (j + 1) + ") element (or X to exit): ");
                    String elementInput = scanner.next().trim().toUpperCase();

                    if (elementInput.equals("X")) {
                        scanner.nextLine();
                        return null; // Çıkış
                    }

                    if (elementInput.matches("-?\\d+(\\.\\d+)?")) {
                        matrix[i][j] = Double.parseDouble(elementInput);
                        clearConsole();
                        break;
                    } else {
                        clearConsole();
                        err = true;
                    }
                }
            }
        }
        return matrix;
    }

    /**
     * Computes and displays the transpose of a matrix entered by the user.
     *
     * @param scanner Scanner for user input.
     */
    public static void transposeMatrix(Scanner scanner)
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS: TRANSPOSE");

        double[][] matrix = getMatrix(scanner,"TRANSPOSE");
        if(matrix == null)
            return;
        
        clearConsole();
        System.out.println("MATRIX OPERATIONS: TRANSPOSE");
        System.out.println("Entered Matrix");
        printMatrix(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transposed Matrix:");
        printMatrix(transpose);

        System.out.println("Press enter to return to matrix operations menu: ");
        scanner.nextLine();
    }

    /**
     * Computes and displays the inverse of a square matrix entered by the user.
     * Uses Gauss-Jordan elimination to compute the inverse.
     *
     * @param scanner Scanner for user input.
     */
    public static void inverseMatrix(Scanner scanner)
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS: INVERSE");
        int rows = 0;

        rows = getSize(scanner, "Enter the rows of the matrix (columns will be automatically assigned to same size) (or X to exit): ", "MATRIX OPERATIONS", "MATRIX OPERATIONS: INVERSE");
        if(rows == -1)
            return;

        clearConsole();
        double[][] matrix = getParamaterizedMatrix(rows, rows, scanner, "INVERSE");
        if(matrix == null)
            return;

        double[][] augmented = new double[rows][2 * rows];

        // Build the augmented matrix [matrix | identity]
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                augmented[i][j] = matrix[i][j];
            }
            augmented[i][i + rows] = 1;
        }

        // Apply Gauss-Jordan elimination
        for (int i = 0; i < rows; i++) {
            double diagElement = augmented[i][i];
            if (diagElement == 0) {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: INVERSE");
                printMatrix(matrix);
                System.out.println("Matrix is singular and cannot be inverted.");
                scanner.nextLine();
                System.out.println("Press enter to return to matrix operations menu: ");
                scanner.nextLine();
                clearConsole();
                return;
            }

            for (int j = 0; j < 2 * rows; j++) {
                augmented[i][j] /= diagElement;
            }

            for (int k = 0; k < rows; k++) {
                if (k != i) {
                    double factor = augmented[k][i];
                    for (int j = 0; j < 2 * rows; j++) {
                        augmented[k][j] -= factor * augmented[i][j];
                    }
                }
            }
        }

        // Extract the inverse from the augmented matrix
        double[][] inverse = new double[rows][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                inverse[i][j] = augmented[i][j + rows]; // Copy the right side of augmented to inverse
            }
        }

        clearConsole();
        System.out.println("MATRIX OPERATIONS: INVERSE");
        System.out.println("Entered Matrix");
        printMatrix(matrix);
        System.out.println("\nInverse of the Matrix");
        printMatrix(inverse);

        scanner.nextLine();
        System.out.println("Press enter to return to matrix operations menu: ");
        scanner.nextLine();
    }

    /**
     * Multiplies two matrices entered by the user and displays the resulting matrix.
     * Validates that the matrices have compatible dimensions.
     *
     * @param scanner Scanner for user input.
     */
    public static void matrixMultiplication(Scanner scanner)
    {
        int rows1 = 0;
        int cols1 = 0;
        int cols2 = 0;
        clearConsole();
        
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION\nFirst Matrix");

        rows1 = getSize(scanner, "Enter the rows of the first matrix (or X to exit): ", "MATRIX OPERATIONS", "MATRIX OPERATIONS: MATRIX MULTIPLICATION\nFirst Matrix");
        if(rows1 == -1)
            return;

        clearConsole();
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION\nFirst Matrix");

        cols1 = getSize(scanner, "Enter the columns of the first matrix (or X to exit): ", "MATRIX OPERATIONS", "MATRIX OPERATIONS: MATRIX MULTIPLICATION\nFirst Matrix");
        if(cols1 == -1)
            return;

        clearConsole();
        double[][] matrix1 = getParamaterizedMatrix(rows1, cols1 ,scanner ,"MATRIX MULTIPLICATION\nFirst Matrix");
        if(matrix1==null)
            return;

        clearConsole();
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION\nSecond Matrix");

        cols2 = getSize(scanner, "Enter the columns of the second matrix (rows is automatically assigned to " + cols1 + ", columns of the first matrix)(or X to exit): ", "MATRIX OPERATIONS", "MATRIX OPERATIONS: MATRIX MULTIPLICATION\nSecond Matrix");
        if(cols2 == -1)
            return;

        clearConsole();
        double[][] matrix2 = getParamaterizedMatrix(cols1, cols2,scanner,"MATRIX MULTIPLICATION\nSecond Matrix");
        if(matrix2==null)
            return;
        
        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        clearConsole();
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
        System.out.println("First Matrix");
        printMatrix(matrix1);

        System.out.println("Second Matrix");
        printMatrix(matrix2);

        System.out.println("Multiplied Matrix");
        printMatrix(result);

        scanner.nextLine();
        System.out.println("Press enter to return to matrix operations menu: ");
        scanner.nextLine();
    }

    /**
     * Multiplies two matrices element-by-element and displays the resulting matrix.
     * Ensures that both matrices have the same dimensions.
     *
     * @param scanner Scanner for user input.
     */
    public static void elementWiseMultiplication(Scanner scanner)
    {
        clearConsole();
        double[][] matrix1 = getMatrix(scanner,"ELEMENT-WISE MULTIPLICATION\nFirst Matrix");
        if(matrix1==null)
            return;

        int row = matrix1.length;
        int col = matrix1[0].length;
        double[][] matrix2 = getParamaterizedMatrix(row, col,scanner,"ELEMENT-WISE MULTIPLICATION\nSecond Matrix");
        if(matrix2==null)
            return;

        double[][] multipliedMatrix = new double[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                multipliedMatrix[i][j] = matrix1[i][j]*matrix2[i][j];
            }
        }

        System.out.println("MATRIX OPERATIONS: ELEMENT-WISE MULTIPLICATION");
        System.out.println("First Matrix");
        printMatrix(matrix1);

        System.out.println("Second Matrix");
        printMatrix(matrix2);

        System.out.println("Element-wise Multiplied Matrix");
        printMatrix(multipliedMatrix);

        System.out.println("Press enter to return to matrix operations menu: ");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * Prints a matrix in a formatted grid layout.
     *
     * @param matrix The matrix to be printed.
     */
    public static void printMatrix(double[][] matrix)
    {
        int maxLength = getMaxLength(matrix); // get the largest length number

        // Print the top border
        System.out.print("┌");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print("──");
            System.out.print("─".repeat(maxLength));
            if (i < matrix[0].length - 1) System.out.print("┬");
        }
        System.out.println("┐");

        // Print each row with vertical separators
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("│");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%" + maxLength + ".2f  ", matrix[i][j]);
                System.out.print("│");
            }
            System.out.println();

            // Print row separator if not the last row
            if (i < matrix.length - 1) {
                System.out.print("├");
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print("──");
                    System.out.print("─".repeat(maxLength));
                    if (j < matrix[i].length - 1) System.out.print("┼");
                }
                System.out.println("┤");
            }
        }

        // Print the bottom border
        System.out.print("└");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print("──");
            System.out.print("─".repeat(maxLength));
            if (i < matrix[0].length - 1) System.out.print("┴");
        }
        System.out.println("┘");
    }

    /**
     * Helper method to determine the maximum length of formatted values in a matrix.
     * This is used for formatting matrix output to ensure consistent alignment.
     *
     * @param matrix The matrix for which the maximum value length is calculated.
     * @return The maximum length of values when formatted to two decimal places.
     */
    private static int getMaxLength(double[][] matrix) {
        int maxLength = 5; // Default width for values like "0.00"

        for (double[] row : matrix) {
            for (double value : row) {
                int length = String.format("%.2f", value).length();
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength + 1; // Adding 1 for padding
    }

//************************************OPTION C ALL FUNCTIONS****************************************************

    /**
     * This method provides a menu for text encryption and decryption operations.
     * It prompts the user to select either encryption or decryption, enter a key, and
     * input the text to be processed. The method then shifts each character in the text
     * according to the given key using a Caesar cipher approach, with separate handling
     * for uppercase and lowercase letters.
     *
     * @param scanner The Scanner object for reading user input.
     */
    public static void FunctionC(Scanner scanner){
        
        clearConsole();
        
        String errMessage = "";
        while(true){
            int choice=0;//the choice of the submenu
            int key=0;//key value to be entered
            boolean err = false;
            String selected="Encryption";//string to keep the operation user selected
            while(true){//loop until the user inserts a valid input
                System.out.println("TEXT ENCRYPTION/DECRYPTION");
                //print the options
                System.out.println("[1] Encryption");
                System.out.println("[2] Decryption");
                System.out.println("[3] Return to the Main Menu\n");
                if(err){
                    System.out.println(errMessage);
                    err = false;
                }
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
                            err = true;
                            errMessage="Error: The provided key is not in the range [-26, 26]";// the error message
                            //return to the submenu
                        }
                        else{//if not a number
                            clearConsole();
                            err = true;
                            errMessage="Error: The provided key is not a number";// the error message
                            scanner.next();//clear the scanner object to get the next input without any problems
                            //return to the submenu
                        }
                    }
                    else{//if not a valid number
                        clearConsole();
                        err = true;
                        errMessage="Error: " + choice + " is not one of the options";// the error message
                    }
                }
                else{//if not a number
                    clearConsole();
                    err = true;
                    errMessage="Error: Invalid input";//the error message
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

            System.out.println("Press enter to return to Text encryption/decryption menu: ");
            scanner.nextLine();
            clearConsole();
        }
    }

//************************************OPTION D ALL FUNCTIONS****************************************************

    /**
     * This method controls the main flow of the Tic-Tac-Toe game, handling the game board,
     * player turns, and checking for a win or draw condition. It also allows the user
     * to exit mid-game or start a new game after a result is reached.
     *
     * @param scanner The Scanner object for reading user input.
     */
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
                        System.out.println("Error: This cell is taken, please make a new selection.");
                    }
                } else {
                    clearConsole();
                    printBoard(board);
                    System.out.println("Error: Invalid entry, please make a selection between 1 to 9.");
                }
            }

            clearConsole();
            printBoard(board);
            if (gameWon) {
                //ogre font
                if(currentPlayer=='X'){
                    System.out.print("       _                         ____             _           \n" + //
                                                " _ __ | | __ _ _   _  ___ _ __  |___ \\  __      _(_)_ __  ___ \n" + //
                                                "| '_ \\| |/ _` | | | |/ _ \\ '__|   __) | \\ \\ /\\ / / | '_ \\/ __|\n" + //
                                                "| |_) | | (_| | |_| |  __/ |     / __/   \\ V  V /| | | | \\__ \\\n" + //
                                                "| .__/|_|\\__,_|\\__, |\\___|_|    |_____|   \\_/\\_/ |_|_| |_|___/\n" + //
                                                "|_|            |___/                                          \n\n");
                } else{
                    System.out.print("       _                         _            _           \n" + //
                                                " _ __ | | __ _ _   _  ___ _ __  / | __      _(_)_ __  ___ \n" + //
                                                "| '_ \\| |/ _` | | | |/ _ \\ '__| | | \\ \\ /\\ / / | '_ \\/ __|\n" + //
                                                "| |_) | | (_| | |_| |  __/ |    | |  \\ V  V /| | | | \\__ \\\n" + //
                                                "| .__/|_|\\__,_|\\__, |\\___|_|    |_|   \\_/\\_/ |_|_| |_|___/\n" + //
                                                "|_|            |___/                                      \n\n");
                }
            } else {
                System.out.print("     _                    \n" + //
                                        "  __| |_ __ __ ___      __\n" + //
                                        " / _` | '__/ _` \\ \\ /\\ / /\n" + //
                                        "| (_| | | | (_| |\\ V  V / \n" + //
                                        " \\__,_|_|  \\__,_| \\_/\\_/  \n" + //
                                        "                          \n\n");
            }

            System.out.println("Press enter to return to the main menu (or type [p] to play again)");
            String choice = scanner.nextLine().toUpperCase();
            playAgain = choice.equals("P");
            clearConsole();

        } while (playAgain);
    }

    /**
     * Displays the current state of the game board in a formatted structure.
     *
     * @param board The 2D character array representing the Tic-Tac-Toe board.
     */
    public static void printBoard(char[][] board)
    {
        System.out.println(" TIC-TAC-TOE GAME");
        
        System.out.println("┌─────┬─────┬─────┐");
        System.out.printf ("│  %c  │  %c  │  %c  │\n", board[0][0], board[0][1], board[0][2]);
        System.out.println("├─────┼─────┼─────┤");
        System.out.printf ("│  %c  │  %c  │  %c  │\n",  board[1][0], board[1][1], board[1][2]);
        System.out.println("├─────┼─────┼─────┤");
        System.out.printf ("│  %c  │  %c  │  %c  │\n",  board[2][0], board[2][1], board[2][2]);
        System.out.println("└─────┴─────┴─────┘");
    }

    /**
     * Checks if a player has won the game by having three of their symbols in a row,
     * column, or diagonal on the board.
     *
     * @param board  The 2D character array representing the Tic-Tac-Toe board.
     * @param player The character ('X' or 'O') of the current player to check for a win.
     * @return true if the player has won; false otherwise.
     */
    public static boolean checkWin(char[][] board, char player)
    {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            return true;

        return false;
    }

    /**
     * Checks if the board is full, which occurs when all cells contain either 'X' or 'O'.
     * This helps determine if the game has ended in a draw.
     *
     * @param board The 2D character array representing the Tic-Tac-Toe board.
     * @return true if the board is full; false otherwise.
     */
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

    /**
     * Clears the console screen. Uses platform-specific commands to ensure
     * the terminal is cleared on both Windows and Unix-based systems.
     * On Windows, it runs the "cls" command; on Unix-based systems, it sends
     * an ANSI escape sequence to clear the screen.
     */
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

    /**
     * Prompts the user to enter a valid integer size based on provided messages.
     * The method continues prompting until the user provides a positive integer or
     * decides to exit by entering "X". If the user enters "X", it returns -1 to
     * indicate an exit request.
     *
     * @param scanner  The Scanner object for reading user input.
     * @param message1 The message prompting the user to enter a size.
     * @param message2 The message (submenu message) displayed at the title.
     * @param message3 The message (operation message) displayed at the title.
     * @return The integer size entered by the user if valid, or -1 if the user exits.
     */
    public static int getSize(Scanner scanner, String message1, String message2, String message3)
    {
        while (true) {
            int size = 0;
            System.out.print(message1);
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                clearConsole();
                System.out.println(message2);
                return -1; // Çıkış
            }

            if (input.matches("-?\\d+")) {
                size = Integer.parseInt(input);
                if (size >= 1) {
                    return size;
                } else {
                    clearConsole();
                    System.out.println(message3);
                    System.out.println("Error: "+ size +" is not a valid size.");
                }
            } else {
                clearConsole();
                System.out.println(message3);
                System.out.println("Error: Please enter a valid size.");
            }
        }
    }

    /**
     * Displays an artistic representation of the input string with optional animation.
     * The string is processed character by character, and corresponding artistic representations
     * are displayed in a formatted manner. If the `opening` parameter is true, an animated 
     * effect is applied to the display, including blinking and a final message animation.
     *
     * @param input   The input string to be converted to an artistic format. 
     *                This string is converted to uppercase for processing.
     * @param opening A boolean flag indicating whether to display the artistic representation
     *                with group members names animation (true) or without group members names animation (false).
     * @param scanner A Scanner object used to read user input, specifically to wait for
     *                user confirmation to proceed to the main menu after the animation.
     */
    public static void art(String input,boolean opening,Scanner scanner){
            input = input.toUpperCase();
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
        if(opening){
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
            try{
                Thread.sleep(325);
            }
            catch(InterruptedException e){
                e.printStackTrace();
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
    }
}