import java.util.*;

class ATMM {

    private BankAccount account;

    public ATMM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nATM Menu");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
                choice = -1;
            }

            switch (choice) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void withdrawCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("Insufficient funds. Please try a lower amount.");
        }
        scanner.close();
    }

    private void depositCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is $" + account.getBalance());
        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is $" + account.getBalance());
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Set initial balance
        ATMM atm = new ATMM(account);
        atm.run();
    }
}
