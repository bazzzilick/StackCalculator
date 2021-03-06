package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.BadResultException;
import Exceptions.CalculatorException;

import java.util.EmptyStackException;

public class MultiplyCommand extends Command
{
    @Override
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in multiply command");
        }

        if (context.size() < 2) {
            throw new EmptyStackException();
        }

        Double firstOperand = context.pop();
        Double secondOperand = context.pop();

        double operationResult = firstOperand * secondOperand;

        if (Double.isInfinite(operationResult) || Double.isNaN(operationResult))
        {
            context.push(secondOperand);
            context.push(firstOperand);

            throw new BadResultException("Bad result in multiply command");
        }

        context.push(operationResult);
    }
}
