import java.nio.channels.AsynchronousSocketChannel;
import java.util.Date;

/* Chris de Leon
 * CIS170
 * 10/27/2022
 */

public class Exercise09_07 {
    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000.0);
        double APY = 45.0;

        account1.setInterest(APY); // sets interest rate to 4.5

        account1.withdraw(2500.0);

        account1.deposit(3000.0);

        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Monthly Interest: " + account1.getMonthlyInterest());
        System.out.println("Date created: " + account1.getDate());

        System.out.println("APY: " + account1.getAnnualInterestRate());

        

    }

    public static class Account {
        private int id = 0;
        private double balance = 0;
        private double annualInterestRate = 0; // assuming that all classes have the same interest rate
        private Date dateCreated = new Date();

        Account() { // constructor creates default account
        }

        Account (int newId, double initialBalance){ // constructor creates an account with specified id and intitial balance
            id = newId;
            balance = initialBalance;
        }

        public int getId(){
            return id;
        }

        public Account(int newId){
            this.id = newId;
        }

        public double getBalance(){
            return balance;
        }

        public void setBalance(double newBalance){ // the hardest part for me was figuring out how to set a new balance and new APY
            this.balance = newBalance;
        }

        public void setInterest(double newAnnualInterestRate){
            this.annualInterestRate = newAnnualInterestRate;
        }

        public double getAnnualInterestRate() {
            annualInterestRate = annualInterestRate / 100;
            return annualInterestRate;
        }

        public Date getDate(){
            return dateCreated;
        }

        public double getMonthlyInterestRate(){ // returns the monthly interest rate
            annualInterestRate = annualInterestRate / 12;
            return annualInterestRate;
        }

        public double getMonthlyInterest(){ // returns monthly interest
            balance = balance * getMonthlyInterestRate();
            return balance;
        }

        public double withdraw(double num){
            balance -= num;
            return num;
        }

        public double deposit(double num2){
            balance += num2;
            return num2;
        }

        
    }
}
