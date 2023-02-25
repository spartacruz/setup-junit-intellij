public class BankAccount {
    private double balance;
    private double minimumBalance;

    //contractor
    public BankAccount(double balance, double minimumBalance){
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance(){
        return balance;
    }

    public double getMinimumBalance(){
        return minimumBalance;
    }

    public double withdraw(double amount){
        if((balance - amount) > minimumBalance){
            return balance -= amount;
        } else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        return balance += amount;
    }
}
