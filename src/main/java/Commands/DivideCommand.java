package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.BadResultException;
import Exceptions.CalculatorException;
import Exceptions.DivideByZeroException;

public class DivideCommand extends Command
{
    @Override
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong argument count in divide command");
        }

        Double firstOperand = context.pop();

        if (firstOperand == 0)
        {
            context.push(firstOperand);
            throw new DivideByZeroException("divide by zero");
        }

        Double secondOperand = context.pop();

        double operationResult = secondOperand / firstOperand;

        if (Double.isInfinite(operationResult) || Double.isNaN(operationResult))
        {
            context.push(secondOperand);
            context.push(firstOperand);

            throw new BadResultException("bad result in divide command");
        }

        context.push(operationResult);
    }
}
