package domein;

import exceptions.NegativeNumberException;

public class MijnGetal
{
    private double getal;

    public MijnGetal(double getal) throws NegativeNumberException
    {
        setGetal(getal);
    }
    
    private void setGetal(double getal) throws NegativeNumberException
    {
        if (getal < 0)
            throw new NegativeNumberException();
        this.getal = getal;
    }
    
    public double getGetal()
    {
        return getal;
    }
    
    public double geefVierkantswortel()
    {
        return Math.sqrt(getal);
    }
}
