import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful! New balance: $" + String.format("%.2f", balance);
        }
        return "Invalid deposit amount. Please enter a positive value.";
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance. Transaction failed.";
        }
        if (amount <= 0) {
            return "Invalid withdrawal amount. Please enter a positive value.";
        }
        balance -= amount;
        return "Withdrawal successful! New balance: $" + String.format("%.2f", balance);
    }

    public String checkBalance() {
        return "Current balance: $" + String.format("%.2f", balance);
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("\nPlease choose an option (1-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        System.out.println(account.withdraw(withdrawAmount));
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        System.out.println(account.deposit(depositAmount));
                        break;
                    case 3:
                        System.out.println(account.checkBalance());
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select an option between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount("John Doe", 500.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}