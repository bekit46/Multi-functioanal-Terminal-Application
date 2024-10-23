import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//banner3 style for the welcome and all other usages
//big style for the names and group name

public class asciiart {
    public static void main(String[] args) {
        art("welcome".toUpperCase(),true);
    }
    
    public static void art(String input,boolean opening){
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
                //clearconsole()
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
                //until here
        
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
                //clearconsole()
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
                //until here
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
                //clearconsole()
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
                //until here
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
            Scanner start = new Scanner(System.in);
            System.out.print("\n\nPress enter to move to the main menu ");
            start.nextLine();
            start.close();
            //clearconsole()
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
            //until here
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
                //clearconsole()
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
                //until here
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
            Scanner start2 = new Scanner(System.in);
            System.out.print("\n\nPress enter to move to the main menu ");
            start2.nextLine();
            start2.close();
        }
    }
}
