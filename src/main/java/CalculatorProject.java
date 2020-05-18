import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorProject
{
    private static final Logger LOGGER = Logger.getLogger(CalculatorProject.class);

    public static void main(String[] args) {

        BufferedReader bufferedReader;

        if(args.length > 0)
        {
            try
            {
                FileInputStream inputStream = new FileInputStream(args[0]);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                LOGGER.trace("name of file with commands : " + args[0]);

            } catch (IOException e) {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                LOGGER.trace("read commands from System.in");
            }
        }
        else
        {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            LOGGER.trace("read commands from System.in");
        }

        Calculator calculator = new Calculator(bufferedReader);
        calculator.startCalculate();

        try
        {
            bufferedReader.close();
        }
        catch (IOException e)
        {
            LOGGER.error("can't close reader with commands ", e);
        }
    }
}