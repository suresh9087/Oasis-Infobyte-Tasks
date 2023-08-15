import java.util.Scanner;

class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }
}

class ATM {
    private User user;
    private double balance;

    public ATM(User user, double initialBalance) {
        this.user = user;
        this.balance = initialBalance;
    }

    public void showMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Enter your user ID and PIN to continue.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        if (user.authenticate(userId, pin)) {
            System.out.println("Authentication successful!");
            displayOptions();
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    private void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayOptions();
                break;
        }
    }

    private void checkBalance() {
        System.out.println("\nCurrent balance: $" + balance);
        displayOptions();
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }

        displayOptions();
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. Current balance: $" + balance);

        displayOptions();
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            System.out.print("Enter the recipient's user ID: ");
            String recipientId = scanner.next();

            // Perform the transfer logic here

            System.out.println("Transfer successful. Remaining balance: $" + balance);
        }

        displayOptions();
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        User user = new User("123456", "7890");
        ATM atm = new ATM(user, 1000.0);
        atm.showMenu();
    }
}