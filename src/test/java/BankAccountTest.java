import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testWithdraw(){
        //new instance
        BankAccount bankAccount = new BankAccount(5000, 500);
        bankAccount.withdraw(2000);
        assertEquals(3000, bankAccount.getBalance());
    }

    @Test
    public void testDeposit(){
        //new instance
        BankAccount bankAccount = new BankAccount(7000, 100);
        bankAccount.deposit(5000);
        assertEquals(12000, bankAccount.getBalance());
    }
}
