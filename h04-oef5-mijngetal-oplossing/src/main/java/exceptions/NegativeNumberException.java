package exceptions;

public class NegativeNumberException 
                    extends Exception
{
    public NegativeNumberException()
    {
        super("Getal mag niet negatief zijn!");
    }

    public NegativeNumberException(String msg)
    {
        super(msg);
    }
}
