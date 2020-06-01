import Commands.Command;
import Commands.Context;
import Commands.PrintCommand;
import Exceptions.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushCommandTest {

    @Test
    public void doOperation() {
        Context context = new Context();
        CommandFactory commandFactory = new CommandFactory();

        String[] commandArgs = {"PUSH", "0"};
        String commandName = commandArgs[0].toLowerCase();

        try
        {
            Command command = commandFactory.buildCommand(commandName);
            command.doCommand(commandArgs, context);

            assertEquals(0.0, PrintCommand.getValue(context), 0);

        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

}