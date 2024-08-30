import java.util.Scanner;
public class ATM 
{
    private BankAccount userAccount;
    private Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount userAccount) 
    {
        this.userAccount = userAccount;
    }
    public void startATM() 
    {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void displayMenu()
    {
        System.out.println("\nATM Interface");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private void checkBalance()
    {
        System.out.println("Your account balance: \u20B9" + userAccount.getBalance());
    }

    private void deposit() 
    {
        System.out.print("Enter deposit amount: \u20B9");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Your new balance: \u20B9" + userAccount.getBalance());
    }

    private void withdraw() 
    {
        System.out.print("Enter withdrawal amount: \u20B9");
        double amount = scanner.nextDouble();
        if (amount <= 0) 
        {
            System.out.println("Invalid amount. Withdrawal failed.");
        } else if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance: \u20B9" + userAccount.getBalance());
        }
    }
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(50000.0); // Example initial balance in INR
        ATM atm = new ATM(account);
        atm.startATM();
    }
}
class BankAccount {

    private double balance;
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } 
        else 
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}
