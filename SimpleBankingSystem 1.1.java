import java.util.Scanner;

public class SimpleBankingSystem {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 0.0;
    static String storedPIN;
    public static void bankingMenu() {
        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: deposit(); break;
                case 2: withdraw(); break;
                case 3: checkBalance(); break;
                case 4: System.out.println("Thank you for using the banking system!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    public static void deposit() {

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public static void withdraw() {

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void checkBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }

    public static void main(String[] args) {
        System.out.print("Create a 4-digit PIN: ");
        storedPIN = scanner.nextLine();
        if (storedPIN.length() % 4 != 0){
            System.out.println("Invalid PIN format. PIN must be 4 digits.");
            return;
        }
        for (int i = 0; i <= 3; i++){
            if (!Character.isDigit(storedPIN.charAt(i))){
                System.out.println("Invalid PIN format. PIN must be 4 digits only.");
                return;
            }

        }



        if (verifyPIN()) {
            bankingMenu();
        } else {
            System.out.println("Too many incorrect attempts. Access denied.");
        }
    }

    public static boolean verifyPIN() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            String inputPIN = scanner.nextLine();
            if (inputPIN.equals(storedPIN)) {
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }
        return false;
    }


}