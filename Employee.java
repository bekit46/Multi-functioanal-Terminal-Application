import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class Employee {
    // Protected attributes accessible by subclasses
    protected int employeeId;
    protected String username;
    protected String password;
    protected EmployeeRole role;
    protected String name;
    protected String surname;
    protected String phoneNo;
    protected String dateOfBirth;
    protected String dateOfStart;
    protected String email;
    Scanner scanner = new Scanner(System.in);

    // Constructor to initialize all attributes
    public Employee(int employeeId, String username, String password, EmployeeRole role,
                    String name, String surname, String phoneNo,
                    String dateOfBirth, String dateOfStart, String email) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
        this.dateOfStart = dateOfStart;
        this.email = email;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void displayProfile();
    public abstract void updateDB(Employee obj);
    public abstract void updateProfile(Employee obj,String header, String val);
    public abstract void displayMenu();
    

    // Concrete methods for commonly shared functionality
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String newPassword) {
        if (newPassword.length() >= 8 && !newPassword.equals("password123")) {
            this.password = newPassword;
            System.out.println("Password successfully updated.");
        } else {
            System.out.println("Password must be at least 8 characters and not 'password123'.");
        }
    }

    public static String getValidPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;

        // Define a regex pattern for a valid phone number
        String phoneRegex = "^(\\+\\d{1,3})?\\d{10}$"; // Supports optional country code (+1, +44, etc.) and 10-digit numbers
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Phone Number Validation Tab ===");
            System.out.print("Enter a valid phone number (e.g., +1234567890 or 1234567890): ");
            phoneNumber = scanner.nextLine();

            if (phoneNumber.matches(phoneRegex)) {
                isValid = true;
            } else {
                System.out.println("Invalid phone number. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Consume the newline character from nextInt()
            }
        } while (!isValid);
        System.out.println("Phone number is valid");
        return phoneNumber;
    }

    public static String getValidEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;

        // Define a regex pattern for a valid email address
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Email Address Validation Tab ===");
            System.out.print("Enter a valid email address (e.g., example@domain.com): ");
            email = scanner.nextLine().trim();

            if (email.matches(emailRegex)) {
                isValid = true;
            } else {
                System.out.println("Invalid email address. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Email address is valid.");
        return email;
    }

    public static String getValidDate(String title) {
        Scanner scanner = new Scanner(System.in);
        String dateInput;
        LocalDate validDate = null;

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("===   " + title + " Date Validation Tab   ===");
            System.out.print("Enter a valid date (format: YYYY-MM-DD): ");
            dateInput = scanner.nextLine().trim();

            try {
                validDate = LocalDate.parse(dateInput, formatter);
                isValid = true; // If parsing succeeds, the date is valid
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Date is valid.");
        return validDate.format(formatter); // Return the date in the specified format
    }

    public static String getValidPassword() {
        Scanner scanner = new Scanner(System.in);
        String password;
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Password Validation Tab ===");
            System.out.print("Enter a valid password (at least 8 characters): ");
            password = scanner.nextLine().trim();

            if (password.length() >= 8) {
                isValid = true;
            } else {
                System.out.println("Invalid password. Password must be at least 8 characters long.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Password is valid.");
        return password;
    }

    public static String getValidUsername() {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Username Validation Tab ===");
            System.out.print("Enter a valid username (maximum 16 characters): ");
            username = scanner.nextLine().trim();

            if (username.length() <= 16) {
                isValid = true;
            } else {
                System.out.println("Invalid username. Username must be at most 16 characters long.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Username is valid.");
        return username;
    }

    public static String getValidName() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String name;
        boolean isValid = false;
    
        do {
            clearTerminal();
            System.out.println("=== Name Validation Tab ===");
            System.out.print("Enter a valid name (only alphabetic characters, max 16 characters): ");
            name = scanner.nextLine().trim();
    
            // Regular expression that includes Turkish characters
            if (name.length() <= 16 && name.matches("[A-Za-zçÇıığĞöÖşŞüÜ]+")) {
                isValid = true;
            } else {
                System.out.println("Invalid name. Name must be at most 16 characters long and contain only alphabetic characters.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);
    
        System.out.println("Name is valid.");
        return name;
    }    

    public static String getValidSurname() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String surname;
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Surname Validation Tab ===");
            System.out.print("Enter a valid surname (only alphabetic characters, maximum 16 characters): ");
            surname = scanner.nextLine().trim();

            if (surname.length() <= 16 && surname.matches("[A-Za-zçÇıığĞöÖşŞüÜ]+")) {
                isValid = true;
            } else {
                System.out.println("Invalid Surname. Surname must be at most 16 characters long and contain only alphabetic characters.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Surname is valid.");
        return surname;
    }

    public static String getValidRole() {
        Scanner scanner = new Scanner(System.in);
        String role;
        boolean isValid = false;

        do {
            clearTerminal();
            System.out.println("=== Update Role Menu ===");
            System.out.print("Enter a valid role (intern, manager, technician, engineer): ");
            role = scanner.nextLine().trim().toLowerCase();

            if (role.equals("intern") || role.equals("manager") || role.equals("technician") || role.equals("engineer")) {
                isValid = true;
            } else {
                System.out.println("Invalid role. Please enter one of the following roles: intern, manager, technician, or engineer.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (!isValid);

        System.out.println("Role is valid.");
        return role;
    }
    
    
    // Getters and Setters for encapsulation
    public int getEmployeeId() {
        return employeeId;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role.name(); // Assuming EmployeeRole is an Enum
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRole(EmployeeRole role) {
        this.role = role;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    private static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Consume the newline character from nextInt()
        scanner.nextLine(); // Wait for the user to press Enter
    }

    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}