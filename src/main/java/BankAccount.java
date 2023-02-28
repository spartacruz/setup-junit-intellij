public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive = true;
    private String holderName;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount){
        if((balance - amount) > minimumBalance){
            return balance -= amount;
        } else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount) {
//        for testing assertTimeout
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return balance += amount;
    }
}
