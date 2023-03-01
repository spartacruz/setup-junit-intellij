import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {

    @RepeatedTest(3)
    @DisplayName("Deposit $5000 successfully")
    public void testDeposit(BankAccount bankAccount){
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
    }

    @RepeatedTest(3)
    @DisplayName("Deposit $5000 successfully")
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo){
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
        System.out.println(repetitionInfo.getCurrentRepetition());
    }
}
