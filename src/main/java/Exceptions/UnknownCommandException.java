package Exceptions;

public class UnknownCommandException extends CalculatorException {
    public UnknownCommandException(String message)
    {
        super(message);
    }
}
