import java.util.Scanner;

public class Function_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMatrix Operations Menu:");
            System.out.println("[1] Create Matrix");
            System.out.println("[2] Transpose Matrix");
            System.out.println("[3] Multiply Matrices");
            System.out.println("[4] Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    functionB();
                    break;
                case 2:
                    handleTranspose();
                    break;
                case 3:
                    handleMultiplication();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    public static void functionB() {
        double[][] matrix = getMatrix();
        if (matrix != null) {
            clearConsole();
            printMatrixFrame(matrix);
        }
    }

    private static double[][] getMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        // Get row value from the user
        while (true) {
            System.out.print("Enter the rows of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return null; // Exit
            }

            if (input.matches("\\d+")) {
                rows = Integer.parseInt(input);
                if (rows >= 1 && rows <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS");
                    System.out.println("Error: Matrix rows must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        // Get column value from the user
        while (true) {
            System.out.print("Enter the columns of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return null; // Exit
            }

            if (input.matches("\\d+")) {
                cols = Integer.parseInt(input);
                if (cols >= 1 && cols <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS");
                    System.out.println("Error: Matrix columns must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        // Create the matrix
        double[][] matrix = new double[rows][cols];

        // Get the values for the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    clearConsole();
                    printMatrixFrame(matrix);

                    System.out.print("Enter value for element (" + (i + 1) + ", " + (j + 1) + "): ");
                    String elementInput = scanner.next().trim().toUpperCase();

                    if (elementInput.equals("X")) {
                        return null; // Çıkış
                    }

                    if (elementInput.matches("-?\\d+(\\.\\d+)?")) {
                        matrix[i][j] = Double.parseDouble(elementInput);
                        break;
                    } else {
                        clearConsole();
                        System.out.println("MATRIX OPERATIONS");
                        System.out.println("Error: Please enter a valid number!");
                    }
                }
            }
        }

        clearConsole();
        System.out.println("Final Matrix:");
        printMatrixFrame(matrix);

        return matrix;
    }
    // Matrix Transpose
    private static void handleTranspose() {
        double[][] matrix = getMatrix();
        if (matrix == null) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transposed Matrix:");
        printMatrixFrame(transpose);
    }
    // Matrix Multiplication
    private static void handleMultiplication() {
        System.out.println("Enter the details for the first matrix:");
        double[][] matrix1 = getMatrix();
        if (matrix1 == null) {
            return;
        }

        System.out.println("Enter the details for the second matrix:");
        double[][] matrix2 = getMatrix();
        if (matrix2 == null) {
            return;
        }

        if (matrix1[0].length != matrix2.length) {
            System.out.println("Error: The number of columns in the first matrix must equal the number of rows in the second matrix for multiplication.");
            return;
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Result of Matrix Multiplication:");
        printMatrixFrame(result);
    }

    private static void printMatrixFrame(double[][] matrix) {
        System.out.println("\nCurrent Matrix Frame:");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f   ", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
