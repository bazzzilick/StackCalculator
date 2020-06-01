package Commands;

import java.util.HashMap;
import java.util.Stack;

public class Context extends Stack<Double>
{
    private HashMap<String, Double> defines = new HashMap<String, Double>();

    public void addDefinition(String constantName, Double constantValue)
    {
        defines.put(constantName, constantValue);
    }

    public boolean isDefined(String constantName)
    {
        return defines.containsKey(constantName);
    }

    public Double getConstant(String constantName)
    {
        return defines.get(constantName);
    }
}
