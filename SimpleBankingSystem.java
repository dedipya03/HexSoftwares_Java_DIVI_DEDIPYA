import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String name;
    private int customerId;
    private ArrayList<BankAccount> accounts;

    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber) {
        BankAccount newAccount = new BankAccount(accountNumber);
        accounts.add(newAccount);
        System.out.println("Account " + accountNumber + " created for " + name);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer customer = new Customer(name, customerId);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number to create: ");
                    String accountNumber = scanner.nextLine();
                    customer.createAccount(accountNumber);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount account = customer.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = customer.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = customer.getAccount(accountNumber);
                    if (account != null) {
                        account.checkBalance();
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the banking system.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

