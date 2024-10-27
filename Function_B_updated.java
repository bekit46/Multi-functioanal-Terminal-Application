import java.util.Scanner;

public class Function_B_updated {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        matrixoperations(scanner);
        scanner.close();
    }
    public static void matrixoperations(Scanner scanner) {
        boolean exit = false;
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        while (!exit) {
            System.out.println("[1] Transpose Matrix");
            System.out.println("[2] Inverse Matrix");
            System.out.println("[3] Matrix Multiplication");
            System.out.println("[4] Element-Wise Multiplication");
            System.out.println("[5] Exit");
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
                    System.out.println("MATRIX OPERATIONS");
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static double[][] getMatrix(Scanner scanner,String operation)
    {
        int rows = 0;
        int cols = 0;
        
        // Satır sayısını al
        while (true) {
            System.out.print("Enter the rows of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                return null; // Çıkış
            }

            if (input.matches("\\d+")) {
                rows = Integer.parseInt(input);
                if (rows >= 1 && rows <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS: "+operation);
                    System.out.println("Error: Matrix rows must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: "+operation);
                System.out.println("Error: Please enter a valid size!");
            }
        }
        clearConsole();
        System.out.println("MATRIX OPERATIONS: "+operation);
        // Sütun sayısını al
        while (true) {
            System.out.print("Enter the columns of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                return null; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols = Integer.parseInt(input);
                if (cols >= 1 && cols <= 5) {
                    clearConsole();
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS: "+operation);
                    System.out.println("Error: Matrix columns must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: "+operation);
                System.out.println("Error: Please enter a valid size!");
            }
        }

        // Matrisi oluştur
        double[][] matrix = new double[rows][cols];
        boolean err = false;

        // Elemanları al
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.println("MATRIX OPERATIONS: "+operation);
                    printMatrix(matrix);

                    if(err)
                    {
                        System.out.println("Error: Please enter a valid number!");
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
                        System.out.println("Error: Please enter a valid number!");
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

    public static void transposeMatrix(Scanner scanner)
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS: TRANSPOSE");

        double[][] matrix = getMatrix(scanner,"TRANSPOSE");
        if(matrix == null){
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            return;
        }
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

        System.out.println("Press enter to return to the main menu: ");
        scanner.nextLine();
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
    }

    public static void inverseMatrix(Scanner scanner)
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        System.out.println("Inverse is not ready for now: ");

        System.out.println("Press enter to return to the main menu: ");
        scanner.nextLine();
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
    }

    public static void matrixMultiplication(Scanner scanner)
    {
        int rows1 = 0;
        int cols1 = 0;
        int cols2 = 0;
        clearConsole();
        
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
        while (true) {
            System.out.print("Enter the rows of the first matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                rows1 = Integer.parseInt(input);
                if (rows1 >= 1 && rows1 <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                    System.out.println("Error: Matrix rows must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        clearConsole();
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
        while (true) {
            System.out.print("Enter the cols of the first matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols1 = Integer.parseInt(input);
                if (cols1 >= 1 && cols1 <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                    System.out.println("Error: Matrix cols must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        clearConsole();
        double[][] matrix1 = getParamaterizedMatrix(rows1, cols1,scanner,"MATRIX MULTIPLICATION");
        if(matrix1==null){
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            return;
        }
        clearConsole();
        System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
        while (true) {
            System.out.printf("Enter the cols of the second matrix (rows is automatically assigned to " + cols1 + " ,cols of the first matrix)(or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                scanner.nextLine();
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols2 = Integer.parseInt(input);
                if (cols2 >= 1 && cols2 <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                    System.out.println("Error: Matrix cols must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS: MATRIX MULTIPLICATION");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        clearConsole();
        double[][] matrix2 = getParamaterizedMatrix(cols1, cols2,scanner,"MATRIX MULTIPLICATION");
        if(matrix2==null){
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            return;
        }
        
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
        System.out.println("Press enter to return to the main menu: ");
        scanner.nextLine();
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
    }


    public static void elementWiseMultiplication(Scanner scanner)
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS: ELEMENT-WISE MULTIPLICATION");
        double[][] matrix1 = getMatrix(scanner,"ELEMENT-WISE MULTIPLICATION");
        if(matrix1==null){
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            return;
        }
        int row = matrix1.length;
        int col = matrix1[0].length;
        double[][] matrix2 = getParamaterizedMatrix(row, col,scanner,"ELEMENT-WISE MULTIPLICATION");
        if(matrix2==null){
            clearConsole();
            System.out.println("MATRIX OPERATIONS");
            return;
        }
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

        System.out.println("Press enter to return to the main menu: ");
        scanner.nextLine();
        scanner.nextLine();
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
    }

    private static void printMatrix(double[][] matrix)
    {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f   ", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
    