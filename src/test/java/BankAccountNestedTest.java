import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount Class")
public class BankAccountNestedTest {

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

    @Nested
    class WhenBalanceEqualZero {

        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        public void testWithdrawMinimumBalanceIs0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing and getting a negative balance")
        public void testWithdrawMinimumBalanceNegative1000() {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }
}
