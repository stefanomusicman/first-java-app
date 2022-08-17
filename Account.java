import java.util.Scanner;

public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    Account(String clientName, String clientID) {
        customerName = clientName;
        customerID = clientID;
    }

    //Method for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Method for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Method for showing previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    //Method for calculating interest
    void calculateInterest(int years) {
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance + "$");
    }

    //Method for showing menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
            //Case "A" allows the user to check their account balance
            case 'A':
                System.out.println("===============================");
                System.out.println("Balance = $" + balance);
                System.out.println("===============================");
                System.out.println();
                break;
            //Case 'B allows the user to make a deposit'
            case 'B':
                System.out.println("Enter amount to deposit: ");
                int amount = scanner.nextInt();
                deposit(amount);
                System.out.println();
                break;
            //Case 'C' allows user to withdraw money
            case 'C':
                System.out.println("Enter amount to withdraw: ");
                int amount2 = scanner.nextInt();
                withdraw(amount2);
                System.out.println();
                break;
            //Case 'D' allows user to view previous transaction
            case 'D':
                System.out.println("===============================");
                getPreviousTransaction();
                System.out.println("===============================");
                System.out.println();
                break;
            //Case 'E' allows user to calulate interest over a specified amount of time in years
            case 'E':
                System.out.println("Enter how many years of accrued interest: ");
                int years = scanner.nextInt();
                calculateInterest(years);
                break;
            //Case 'F' allows user to exit
            case 'F':
                System.out.println("===============================");
                break;
            //Default case informs user that their sumbitted an invalid command
            default:
                System.out.println("Error: Invalid option. Please enter A, B, C, D, E or F");
                break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    } 
}
