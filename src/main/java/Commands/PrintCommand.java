package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.CalculatorException;

public class PrintCommand extends Command
{
    @Override
    public  void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in print command");
        }

        System.out.println(context.peek());
    }

    public static double getValue(Context context)
    {
        return context.peek();
    }
}
