package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.BadResultException;
import Exceptions.CalculatorException;

import java.util.EmptyStackException;

public class SubtractionCommand extends Command
{
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in subtraction command");
        }

        if (context.size() < 2) {
            throw new EmptyStackException();
        }

        Double firstOperand = context.pop();
        Double secondOperand = context.pop();

        double operationResult = secondOperand - firstOperand;

        if (Double.isInfinite(operationResult) || Double.isNaN(operationResult))
        {
            context.push(secondOperand);
            context.push(firstOperand);

            throw new BadResultException("bad result in subtraction command");
        }

        context.push(operationResult);
    }
}
