import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Function_A 
{
    public static void clearConsole() 
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

    public static int getSize(Scanner scanner, String message1, String message2, String message3)
    {
        while (true) 
        {
            int size = 0;
            System.out.print(message1);
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) 
            {
                scanner.nextLine();
                clearConsole();
                System.out.println(message2);
                return -1; // Çıkış
            }

            if (input.matches("-?\\d+")) 
            {
                size = Integer.parseInt(input);
                if (size >= 1) 
                {
                    return size;
                } 
                else 
                {
                    clearConsole();
                    System.out.println(message3);
                    System.out.println("Error: " + size + " not greater than 0. Please enter a number greater than 0");
                }
            } 
            else 
            {
                clearConsole();
                System.out.println(message3);
                System.out.println("Error: Please enter a valid size!");
            }
        }
    }

    public static void printarr(double[] array) 
    {
        int maxLength = getMaxLength(array);

        System.out.print("┌");
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print("──");
            System.out.print("─".repeat(maxLength));
            if (i < array.length - 1) System.out.print("┬");
        }
        System.out.println("┐");

        System.out.print("│");
        for (int i = 0; i < array.length; i++) 
        {
            System.out.printf("%" + maxLength + ".2f  ", array[i]);
            System.out.print("│");
        }
        System.out.println();

        System.out.print("└");
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print("─".repeat(maxLength));
            System.out.print("──");
            if (i < array.length - 1) System.out.print("┴");
        }
        System.out.println("┘");
    }

    private static int getMaxLength(double[] array) 
    {
        int maxLength = 5; 

        for (double value : array) 
        {
            int length = String.format("%.2f", value).length();
            if (length > maxLength) 
            {
                maxLength = length;
            }
        }
        return maxLength + 1; 
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
        sum += (float) 1 / arr[index];
        if (index == arr_size - 1) 
        {
            return arr_size / sum;
        }
        return harmonic_mean(arr_size, arr, index + 1, sum);
    }

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

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        FunctionA(scanner); 
        scanner.close(); 
    }
}
