import Commands.Command;
import Commands.Context;
import Exceptions.CalculatorException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.EmptyStackException;

public class Calculator
{
    private static final Logger LOGGER = Logger.getLogger(Calculator.class);

    private static CommandFactory commandFactory = new CommandFactory();

    private BufferedReader commandReader;
    private Context context;

    public Calculator(BufferedReader commandReader) {
        this.commandReader = commandReader;
        this.context = new Context();
    }

    public void startCalculate() {
        try
        {
            String currentCommand;
            while((currentCommand = commandReader.readLine()) != null)
            {
                try
                {
                    doOperation(currentCommand);
                }
                catch (CalculatorException e)
                {
                    LOGGER.error("can't do operation : ", e);
                    System.out.println(e.getMessage());
                }
                catch (EmptyStackException e)
                {
                    LOGGER.error("can't do operation : ", e);
                    System.out.println("Stack is empty");
                }
            }
        } catch (IOException e) {
            LOGGER.error("can't read next command", e);
            System.out.println(e.getMessage());
        }
    }

    private void doOperation(String currentCommand) throws CalculatorException {
        String[] commandArgs = currentCommand.split(" ");

        String commandName = commandArgs[0];
        /*if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("command name : " + commandName);
        }*/
        LOGGER.trace("command name : " + commandName);

        if (commandName.equals("EXIT"))
        {
            System.exit(0);
        }

        Command command = commandFactory.buildCommand(commandName);
        command.doCommand(commandArgs, context);
    }
}
