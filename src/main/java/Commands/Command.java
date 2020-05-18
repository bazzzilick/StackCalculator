package Commands;

import Exceptions.CalculatorException;

public abstract class Command
{
    public abstract void doCommand(String[] args,  Context context) throws CalculatorException;
}