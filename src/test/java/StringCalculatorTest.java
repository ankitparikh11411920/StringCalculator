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
        assertEquals(15,calculator.add("1,2,3,4,5"));
        assertEquals(55,calculator.add("1,2,3,4,5,6,7,8,9,10"));
        assertEquals(300,calculator.add("11,11,11,1,45,23,98,100,7654"));
        assertEquals(6,calculator.add("1\n2,3"));
        assertEquals(55,calculator.add("1\n2\n3\n4,5,6\n7,8\n9,10"));
        assertEquals(3,calculator.add("//;\n1;2"));
        assertEquals(15,calculator.add("//#\n1#2#3#4#5"));
        assertEquals(0,calculator.add("//#\n1#2#3#-4#5"));
        assertEquals(0,calculator.add("1,2,3,-4,5"));
        assertEquals(0,calculator.add("-1,-2,-3,-4,-5"));
        assertEquals(14,calculator.getCalledCount());
        assertEquals(100, calculator.add("//;\n1;2;3;4;5;85;1001"));

    }
}
