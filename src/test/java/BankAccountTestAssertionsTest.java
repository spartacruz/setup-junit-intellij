import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount Class")
public class BankAccountTestAssertionsTest {

    @Test
    @DisplayName("Withdraw $2000 successfully")
    public void testWithdraw(){
        //new instance
        BankAccount bankAccount = new BankAccount(5000, 500);
        bankAccount.withdraw(2000);
        assertEquals(3000, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit $5000 successfully")
    public void testDeposit(){
        //new instance
        BankAccount bankAccount = new BankAccount(7000, 100);
        bankAccount.deposit(5000);
        assertEquals(12000, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Yuri");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExeceptions() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    @Test
    @DisplayName("Test Speed Deposit")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
        //assertEquals(0.33, 1/3, "Oops, not the same");
    }
}
