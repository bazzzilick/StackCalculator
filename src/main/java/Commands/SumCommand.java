package Commands;

import Exceptions.ArgumentsCountException;
import Exceptions.BadResultException;
import Exceptions.CalculatorException;

import java.util.EmptyStackException;

public class SumCommand extends Command
{
    public void doCommand(String[] args,  Context context) throws CalculatorException
    {
        if (args.length != 1)
        {
            throw new ArgumentsCountException("wrong count of arguments in sum command");
        }

        if (context.size() > 1) {

            Double firstOperand = context.pop();
            Double secondOperand = context.pop();

            double operationResult = firstOperand + secondOperand;

            if (Double.isInfinite(operationResult) || Double.isNaN(operationResult)) {
                context.push(secondOperand);
                context.push(firstOperand);

                throw new BadResultException("Bad result in sum command");
            }

            context.push(operationResult);
        }
        else{
            throw new EmptyStackException();
        }
    }
}
