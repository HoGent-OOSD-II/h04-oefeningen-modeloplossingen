package ui;

import domein.DomeinController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThermometerApplicatie
{
	private DomeinController dc;
	
	public ThermometerApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
    public void start()
    {
        Scanner s = new Scanner(System.in);
        int tempF, tempC;
        boolean magStoppen = false;
        
        do
        {
            try
            {
                System.out.print("Geef een gehele temperatuur in �F uit het interval [14,104]: ");
                tempF = s.nextInt();

                dc.updateTemperatuur(tempF);
                tempC = dc.geefTemperatuurInCelsius();

                System.out.printf("De temperatuur in �C is %d%n", tempC);
                magStoppen = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("De invoer moet een geheel getal zijn!");
                s.nextLine(); // vorige input tot aan ENTER weggooien!
            }
        }
        while (!magStoppen);
        
        s.close();
    }
}
