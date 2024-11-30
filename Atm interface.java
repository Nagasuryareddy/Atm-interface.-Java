import java.util.Scanner;

// Class to represent the Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid amount! Deposit must be greater than 0.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Unable to withdraw.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount! Withdrawal must be greater than 0.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        }
    }

    // Check Balance method
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void start() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: ₹" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

// Main class to test the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize the bank account with an initial balance
        BankAccount account = new BankAccount(5000.0); // Initial balance: ₹5000

        // Create an ATM object and start the ATM interface
        ATM atm = new ATM(account);
        atm.start();
    }
}
