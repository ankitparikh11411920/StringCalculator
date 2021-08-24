import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    void inputTest(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0,calculator.add("") );
        assertEquals(1,calculator.add("1"));
        assertEquals(100,calculator.add("100"));
        assertEquals(3,calculator.add("1,2"));
    }
}
