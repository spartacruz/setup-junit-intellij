import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountTestAssumptionsTest {

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
//        assumeTrue(bankAccount != null);
//        assumeTrue(bankAccount == null, "bisa menambahkan msg: tidak benar");
//        assumeFalse(bankAccount == null);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
        assumingThat(bankAccount != null, () -> System.out.println("Hi, this line will be executed"));
        assumingThat(bankAccount == null, () -> System.out.println("this line will not be executed"));
//        assertTrue(bankAccount.isActive());
//        System.out.println("This line will be executed");
    }
}
