import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountDisabledTest {

    @Test
    @DisplayName("Deposit $5000 successfully")
    public void testDeposit1(){
        //new instance
        BankAccount bankAccount = new BankAccount(7000, 100);
        bankAccount.deposit(5000);
        assertEquals(12000, bankAccount.getBalance(), "Unexpected value, should be 12k");
    }

    @Test
    @DisplayName("Deposit $1000 successfully")
//    Without message
    @Disabled
//    @Disabled("Temporarily disabled due to maintenance")
    public void testDeposit2(){
        //new instance
        BankAccount bankAccount = new BankAccount(7000, 100);
        bankAccount.deposit(1000);
        assertEquals(8000, bankAccount.getBalance(), "Unexpected value, should be 8k");
    }
}
