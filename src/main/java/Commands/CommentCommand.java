package Commands;

import Exceptions.CalculatorException;

public class CommentCommand extends Command
{
    @Override
    public void doCommand(String[] args, Context context) throws CalculatorException {
        for (int i = 1; i < args.length; i++)
        {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}