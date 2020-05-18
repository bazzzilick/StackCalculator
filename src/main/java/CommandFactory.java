import Commands.Command;
import Exceptions.CalculatorException;
import Exceptions.UnknownCommandException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CommandFactory
{
    private static Logger LOGGER = Logger.getLogger(CommandFactory.class);

    private static HashMap<String, String> classConformity = new HashMap<String, String>();

    public CommandFactory()
    {
        try
        {
            InputStream classes = CommandFactory.class.getResourceAsStream("ClassConfigFile");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classes));

            String conformity;
            String[] commandAndClassName;

            while ((conformity = bufferedReader.readLine()) != null)
            {
                commandAndClassName = conformity.split(" ");

                classConformity.put(commandAndClassName[0], commandAndClassName[1]);
            }

            LOGGER.trace("file with classes was open successful");
        }
        catch (IOException e)
        {
            LOGGER.fatal("can't open file with command classes", e);
            System.out.println("File with conformity has problem");
        }
    }

    public Command buildCommand(String commandName) throws CalculatorException
    {
        Command currentCommand;
        String  commandClassName = classConformity.get(commandName);

        try
        {
            Class c = Class.forName(commandClassName);
            Object obj = c.newInstance();
            currentCommand = (Command) obj;
        }
        catch (NullPointerException e)
        {
            LOGGER.error("try to do unknown command : ", e);
            throw new UnknownCommandException("Unknown command");
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.error("try to do unknown command : ", e);
            throw new UnknownCommandException("Unknown command");
        }
        catch (InstantiationException e)
        {
            LOGGER.error("trouble with get instance of class ", e);
            throw new CalculatorException("cannot download class with command");
        }
        catch (IllegalAccessException e)
        {
            LOGGER.error("trouble with get instance of class ", e);
            throw new CalculatorException("cannot download class with command");
        }

        return currentCommand;
    }
}
