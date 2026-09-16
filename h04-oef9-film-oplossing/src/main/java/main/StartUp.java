
package main;

import domein.DomeinController;
import exceptions.LegeStringException;
import ui.VertoonbaarApplicatie;

public class StartUp {
    public static void main(String[] args) {
        
    	DomeinController dc;
		try
		{
			dc = new DomeinController();
	    	VertoonbaarApplicatie app = new VertoonbaarApplicatie(dc);
	    	app.start();
		} 
		catch (LegeStringException | IllegalArgumentException e)
		{
			System.out.println("Gegevens uit database kloppen niet. Het programma stopt hier!");
		}
		catch (Exception e)
		{
			System.out.println("Onverwachte fout. Het programma stopt hier!");
		}
    }
}
