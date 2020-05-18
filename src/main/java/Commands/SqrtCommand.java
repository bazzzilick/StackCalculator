package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.CalculatorException;

public class SqrtCommand extends Command
{
    @Override
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in sqrt command");
        }

        Double numberForSqrt = context.pop();

        if (numberForSqrt < 0)
        {
            context.push(numberForSqrt);
            throw new ArithmeticException("try get sqrt from numb less zero");
        }

        context.push(Math.sqrt(numberForSqrt));
    }
}

