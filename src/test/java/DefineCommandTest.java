import Commands.PrintCommand;
import Exceptions.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefineCommandTest {

    @Test
    public void doOperation() {
        CalculatorTest calculatorTest = new CalculatorTest();

        try
        {
            calculatorTest.doOperation("DEFINE a 4");
            calculatorTest.doOperation("PUSH a");

            assertEquals(4.0, PrintCommand.getValue(calculatorTest.context), 0);
        }
        catch (CalculatorException e)
        {
            System.out.println(e.getMessage());
        }
    }

}