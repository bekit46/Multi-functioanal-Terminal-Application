import java.io.IOException;
import java.util.Scanner;

public class projectOptionC {
    public static void main(String[] args){
        OptionC();
    }
    
    public static void OptionC(){
        //option C

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
                        input.close();//close the scanner object to prevent memory leaks
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
        input.close();//close the scanner object to prevent memory leaks
    }
    
    public static void clearConsole(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}