import Commands.PrintCommand;
import Exceptions.CalculatorException;
import Exceptions.DivideByZeroException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivideByZeroTest {

    @Test
    public void doOperation() {
        CalculatorTest calculatorTest = new CalculatorTest();

        try
        {
            calculatorTest.doOperation("PUSH 2");
            calculatorTest.doOperation("PUSH 0");
            calculatorTest.doOperation("/");

            Assert.fail("expected exception");
        }
        catch (DivideByZeroException e)
        {
            assertEquals("divide by zero", e.getMessage());
        }
        catch (CalculatorException e)
        {
            Assert.fail("catch another exception");
            System.out.println(e.getMessage());
        }
    }

}
