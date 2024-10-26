import java.util.Scanner;

public class Function_B_updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        clearConsole();

        while (!exit) {
            System.out.println("MATRIX OPERATIONS");
            System.out.println("[1] Transpose Matrix");
            System.out.println("[2] Inverse Matrix");
            System.out.println("[3] Matrix Multiplication");
            System.out.println("[4] Element-Wise Multiplication");
            System.out.println("[5] Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    transposeMatrix();
                    clearConsole();
                    break;
                case "2":
                    inverseMatrix();
                    clearConsole();
                    break;
                case "3":
                    matrixMultiplication();
                    clearConsole();
                    break;
                case "4":
                    elementWiseMultiplication();
                    clearConsole();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    public static double[][] getMatrix()
    {
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        // Satır sayısını al
        while (true) {
            System.out.print("Enter the rows of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return null; // Çıkış
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

        // Sütun sayısını al
        while (true) {
            System.out.print("Enter the columns of the matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return null; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols = Integer.parseInt(input);
                if (cols >= 1 && cols <= 5) {
                    clearConsole();
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

        // Matrisi oluştur
        double[][] matrix = new double[rows][cols];
        boolean err = false;

        // Elemanları al
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.println("MATRIX OPERATIONS");
                    printMatrix(matrix);

                    if(err)
                    {
                        System.out.println("Error: Please enter a valid number!");
                        err = false;
                    }
                    System.out.print("Enter value for (" + (i + 1) + ", " + (j + 1) + ") element (or X to exit): ");
                    String elementInput = scanner.next().trim().toUpperCase();

                    if (elementInput.equals("X")) {
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

    public static double[][] getParamaterizedMatrix(int row, int col)
    {
        boolean err = false;
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                while (true) {
                    System.out.println("MATRIX OPERATIONS");
                    printMatrix(matrix);

                    if(err)
                    {
                        System.out.println("Error: Please enter a valid number!");
                        err = false;
                    }
                    System.out.print("Enter value for (" + (i + 1) + ", " + (j + 1) + ") element (or X to exit): ");
                    String elementInput = scanner.next().trim().toUpperCase();

                    if (elementInput.equals("X")) {
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

    public static void transposeMatrix()
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS");

        double[][] matrix = getMatrix();
        if(matrix == null)
            return;
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to return to the main menu: ");
        String input = scanner.nextLine();
    }

    public static void inverseMatrix()
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        System.out.println("Inverse is not ready for now: ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to return to the main menu: ");
        String input = scanner.nextLine();
    }

    public static void matrixMultiplication()
    {
        Scanner scanner = new Scanner(System.in);
        int rows1 = 0;
        int cols1 = 0;
        int cols2 = 0;
        clearConsole();
        
        System.out.println("MATRIX OPERATIONS");
        while (true) {
            System.out.print("Enter the rows of the first matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                rows1 = Integer.parseInt(input);
                if (rows1 >= 1 && rows1 <= 5) {
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

        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        while (true) {
            System.out.print("Enter the cols of the first matrix (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols1 = Integer.parseInt(input);
                if (cols1 >= 1 && cols1 <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS");
                    System.out.println("Error: Matrix cols must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        clearConsole();
        double[][] matrix1 = getParamaterizedMatrix(rows1, cols1);

        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        while (true) {
            System.out.printf("Enter the cols of the second matrix (rows is automatically assigned to the " + cols1 + " cols of the first matrix)(or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) {
                return; // Çıkış
            }

            if (input.matches("\\d+")) {
                cols2 = Integer.parseInt(input);
                if (cols2 >= 1 && cols2 <= 5) {
                    break;
                } else {
                    clearConsole();
                    System.out.println("MATRIX OPERATIONS");
                    System.out.println("Error: Matrix cols must be between 1 and 5");
                }
            } else {
                clearConsole();
                System.out.println("MATRIX OPERATIONS");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        clearConsole();
        double[][] matrix2 = getParamaterizedMatrix(cols1, cols2);
        
        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        System.out.println("First Matrix");
        printMatrix(matrix1);

        System.out.println("Second Matrix");
        printMatrix(matrix2);

        System.out.println("Multiplied Matrix");
        printMatrix(result);

        scanner.nextLine();
        System.out.println("Press enter to return to the main menu: ");
        String input = scanner.nextLine();
    }


    public static void elementWiseMultiplication()
    {
        clearConsole();
        System.out.println("MATRIX OPERATIONS");
        double[][] matrix1 = getMatrix();
        int row = matrix1.length;
        int col = matrix1[0].length;
        double[][] matrix2 = getParamaterizedMatrix(row, col);
        double[][] multipliedMatrix = new double[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                multipliedMatrix[i][j] = matrix1[i][j]*matrix2[i][j];
            }
        }

        System.out.println("MATRIX OPERATIONS");
        System.out.println("First Matrix");
        printMatrix(matrix1);

        System.out.println("Second Matrix");
        printMatrix(matrix2);

        System.out.println("Element-wise Multiplied Matrix");
        printMatrix(multipliedMatrix);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to return to the main menu: ");
        String input = scanner.nextLine();
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