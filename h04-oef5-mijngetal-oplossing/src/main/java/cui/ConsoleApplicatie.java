package cui;

import domein.DomeinController;
import exceptions.NegativeNumberException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleApplicatie
{
	private DomeinController dc;
	
    public ConsoleApplicatie(DomeinController dc)
    {
    	this.dc = dc;
    }
    
    public void start()
    {
        Scanner s = new Scanner(System.in);
        boolean nogIetsFout = true;
        
        do
        {
            System.out.print("Geef 2 positieve decimale getallen gescheiden door een spatie: ");
            String invoer = s.nextLine();

            try
            {
                String[] stukjes = invoer.split(" ");
                if (stukjes.length != 2) 
                	throw new NoSuchElementException
                		("Er moeten 2 delen in de invoer zijn gescheiden door een spatie");

                for (String stukje : stukjes)
                {
                    double getal = Double.parseDouble(stukje);
                    dc.startBerekeningVierkantswortel(getal);
                    System.out.printf("De vierkantswortel van %.2f is %.2f%n", 
                    		dc.geefGetal(), dc.geefVierkantswortel());
                }
                nogIetsFout = false;
            } // einde try
            catch (NoSuchElementException | NegativeNumberException e)
            {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e)
            {
                System.out.println("De invoer moet uit decimale getallen bestaan");
            }
        }
        while (nogIetsFout);
    }
}