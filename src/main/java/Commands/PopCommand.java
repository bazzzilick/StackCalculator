package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.CalculatorException;

public class PopCommand extends Command
{
    @Override
    public  void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in pop command");
        }

        context.pop();
    }
}
