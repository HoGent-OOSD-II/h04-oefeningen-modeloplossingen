package domein;

public class Thermometer
{
    private int aantalGraden;
    private static final int ONDERGRENS = 14, BOVENGRENS = 104;

    public Thermometer()
    {
        setAantalGraden(32);
    }
    
    public int getAantalGraden()
    {
        return aantalGraden;
    }

    private void setAantalGraden(int aantalGraden)
    {
		if (aantalGraden < ONDERGRENS || aantalGraden > BOVENGRENS)
		    throw new IllegalArgumentException
		        (String.format("Waarde van temperatuur moet uit het "
		        + "interval [%d,%d] komen!", ONDERGRENS, BOVENGRENS));
		this.aantalGraden = aantalGraden;
    }
    
    public int converteerNaarCelsius()
    {
        return (aantalGraden - 32) * 5 / 9;
    }
    
    public void stelAantalGradenIn(String invoer)
    {
        int graden = Integer.parseInt(invoer);
        setAantalGraden(graden);
    }
}
