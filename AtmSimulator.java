import java.util.Scanner;
import java.util.ArrayList;

public class AtmSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Simulating a real bank account state
        double balance = 1000.00; // Starting balance
        ArrayList<String> transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with initial deposit: ₹1000.00");
        
        boolean running = true;
        System.out.println("=== WELCOME TO THE APEX BANK ATM ===");
        
        while (running) {
            // Displaying a real-world system menu
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Statement (History)");
            System.out.println("5. Exit");
            System.out.print("Please select an option (1-5): ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        // Check Balance
                        System.out.printf("\nYour current balance is: ₹%.2f\n", balance);
                        break;
                        
                    case 2:
                        // Deposit Money
                        System.out.print("\nEnter the amount to deposit: ₹");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            if (depositAmount > 0) {
                                balance += depositAmount;
                                String log = "Deposited: ₹" + depositAmount;
                                transactionHistory.add(log);
                                System.out.printf("Success! ₹%.2f deposited successfully.\n", depositAmount);
                            } else {
                                System.out.println("Invalid amount. Deposit must be greater than zero.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a numerical amount.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                        
                    case 3:
                        // Withdraw Money
                        System.out.print("\nEnter the amount to withdraw: ₹");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount <= 0) {
                                System.out.println("Invalid amount. Withdrawal must be greater than zero.");
                            } else if (withdrawAmount > balance) {
                                System.out.println("Transaction Declined: Insufficient balance!");
                            } else {
                                balance -= withdrawAmount;
                                String log = "Withdrew: ₹" + withdrawAmount;
                                transactionHistory.add(log);
                                System.out.printf("Success! ₹%.2f dispensed. Please collect your cash.\n", withdrawAmount);
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a numerical amount.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                        
                    case 4:
                        // View Mini Statement
                        System.out.println("\n--- MINI STATEMENT ---");
                        if (transactionHistory.isEmpty()) {
                            System.out.println("No recent transactions found.");
                        } else {
                            for (String transaction : transactionHistory) {
                                System.out.println("- " + transaction);
                            }
                        }
                        System.out.printf("Final Available Balance: ₹%.2f\n", balance);
                        break;
                        
                    case 5:
                        // Exit system
                        System.out.println("\nThank you for banking with Apex Bank. Have a great day!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Invalid option! Please pick a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid menu number.");
                scanner.next(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
}
