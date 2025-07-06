

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down...");
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }
}
