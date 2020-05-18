import Commands.PrintCommand;
import Exceptions.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyCommandTest {

    @Test
    public void doOperation() {
        CalculatorTest calculatorTest = new CalculatorTest();

        try
        {
            calculatorTest.doOperation("PUSH 8");
            calculatorTest.doOperation("PUSH 2");
            calculatorTest.doOperation("*");

            assertEquals(16.0, PrintCommand.getValue(calculatorTest.context), 0);
        }
        catch (CalculatorException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
