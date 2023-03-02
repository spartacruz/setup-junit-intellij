import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;


@ExtendWith(BankAccountParameterResolver.class)
//penempatan nya bisa per class (artinya semua test method under class ini)
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class BankAccountTimeoutTest {
    @Test
    //atau bisa juga per method
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);

        //assertTimeout disini bisa digunakan untuk hal yang lebih spesifik
        //hanya proses tertentu
        assertTimeout(Duration.ofMillis(500), ()  -> {
            Thread.sleep(10);
        });
    }


}
