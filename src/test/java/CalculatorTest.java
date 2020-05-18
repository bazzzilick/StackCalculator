import Commands.Command;
import Commands.Context;
import Exceptions.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    public Context context;
    public CommandFactory commandFactory;

    public CalculatorTest()
    {
        context = new Context();
        commandFactory = new CommandFactory();
    }

    public void doOperation(String testingCommand) throws CalculatorException
    {
        String[] commandArgs = testingCommand.split(" ");
        String commandName = commandArgs[0];

        Command command = commandFactory.buildCommand(commandName);
        command.doCommand(commandArgs, context);
    }
}