import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Function_A {

    // Terminal clear
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

    public static void main(String[] args) 
    {
        int array_size = 0;
        double[] user_array;
        Scanner scanner = new Scanner(System.in);
        clearConsole();
        System.out.println("Option A chosen");

        while (true) 
        {
            System.out.print("Enter the size of the array (or X to exit): ");
            String input = scanner.next().trim().toUpperCase();
            if (input.equals("X")) 
            {
                clearConsole();
                System.out.println("Exiting...");
                scanner.close();
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
                    System.out.println("Option A chosen");
                    System.out.println("Error: " + input + " is not greater than 0. Please enter a size greater than 0!");
                }
            } 
            else 
            {
                clearConsole();
                System.out.println("Option A chosen");
                System.out.println("Error: Please enter a valid size!");
            }
        }

        user_array = new double[array_size];
        clearConsole();
        System.out.println("Option A chosen");

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
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                if (isNumeric(elementInput)) 
                { 
                    user_array[i] = Double.parseDouble(elementInput);
                    clearConsole();
                    System.out.println("Option A chosen");
                    break;
                } 
                else 
                {
                    clearConsole();
                    System.out.println("Option A chosen");
                    System.out.println("Error: Please enter a valid number!");
                }
            }
        }

        clearConsole();
        printarr(user_array);
        System.out.println();
        System.out.printf("Aritmetic mean: %.4f\n" , aritmetic_mean(array_size, user_array));
        System.out.printf("Geometric mean: %.4f\n" , geometric_mean(array_size, user_array));
        System.out.printf("Median: %.4f\n" , median(array_size, user_array));
        System.out.printf("Harmonic mean: %.4f\n" , harmonic_mean(array_size, user_array, 0, 0));

        System.out.println("");
        System.out.println("Press any character to return main menu: ");
        String input_exit = scanner.next();

        scanner.close();
    }
}
