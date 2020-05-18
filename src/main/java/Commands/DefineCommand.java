package Commands;

import Exceptions.ArgumentTypeException;
import Exceptions.ArgumentsCountException;
import Exceptions.CalculatorException;

public class DefineCommand extends Command
{
    @Override
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 3)
        {
            throw new ArgumentsCountException("wrong count of arguments in define command");
        }

        try
        {
            String constantName = args[1];
            Double constantValue = Double.valueOf(args[2]);

            context.addDefinition(constantName, constantValue);
        }
        catch (NumberFormatException e)
        {
            throw new ArgumentTypeException("bad type of argument in define command");
        }
    }
}