package Commands;

import Exceptions.ArgumentTypeException;
import Exceptions.ArgumentsCountException;
import Exceptions.CalculatorException;

public class PushCommand extends Command
{
    @Override
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 2)
        {
            throw new ArgumentsCountException("wrong count of arguments in push command");
        }

        if (context.isDefined(args[1]))
        {
            context.push(context.getConstant(args[1]));
        }
        else
        {
            try
            {
                Double value = Double.valueOf(args[1]);
                context.push(value);
            }
            catch (NumberFormatException e)
            {
                throw new ArgumentTypeException("wrong type of argument in push command");
            }
        }
    }
}
