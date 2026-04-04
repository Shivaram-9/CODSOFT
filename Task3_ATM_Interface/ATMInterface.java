import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount!");
        } else {
            balance += amount;
            System.out.println("✅ Amount Deposited Successfully!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal Successful!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n🏧 ATM MACHINE");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;

                case 2:
                    handleWithdraw();
                    break;

                case 3:
                    System.out.println("💰 Current Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("👋 Thank you! Visit Again.");
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }

        } while (choice != 4);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}

// Main Class
public class ATMInterface {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(2000); // initial balance
        ATM atm = new ATM(userAccount);

        atm.showMenu();
    }
}
