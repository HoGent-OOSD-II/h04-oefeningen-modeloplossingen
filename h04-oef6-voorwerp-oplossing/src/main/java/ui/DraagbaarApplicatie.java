package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;

public class DraagbaarApplicatie
{
	private final DomeinController dc;
	private Scanner invoer;

	public DraagbaarApplicatie(DomeinController dc)
	{
		this.dc = dc;
		invoer = new Scanner(System.in);
	}


	public void start()
	{
		int keuze;

		do {
			keuze = geefKeuzeUitMenu();

			boolean gegevensCorrect = false; 

			while(!gegevensCorrect){
				try {

					switch (keuze) {
					case 1 -> voegWapenToe();
					case 2 -> voegSleutelToe();
					case 3 -> voegGebouwToe();
					case 4 -> System.out.printf("%s", dc.geefOverzicht());
					}

					gegevensCorrect = true;

				}catch(NumberFormatException e) {
					System.err.println("Invoer van een ongeldig type!");
					invoer.nextLine();
				}catch(IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			}


		}while(keuze!=5);


	}

	private void voegGebouwToe() {
		String naam = vraagNaam();
        System.out.print("Geef de hoogte: ");
        double hoogte = Double.parseDouble(invoer.nextLine());
        dc.voegGebouwToe(naam, hoogte);
	}

	private void voegSleutelToe() {
		String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef het nummer van de deur: ");
        int deur = Integer.parseInt(invoer.nextLine());
        dc.voegSleutelToe(naam, gewicht, niveau, deur);
	}

	private void voegWapenToe() {
		String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef de kracht: ");
        int kracht = Integer.parseInt(invoer.nextLine());
        System.out.print("Werd het wapen reeds gebruikt (true/false)? ");
        boolean gebruikt = Boolean.parseBoolean(invoer.nextLine());
        dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
	}
	
	private String vraagNaam() {
		System.out.print("Geef een naam (zonder spaties): ");
		String naam = invoer.nextLine();
		if(naam.contains(" "))
			throw new IllegalArgumentException("Naam mag geen spaties bevatten.");
		return naam;
	}

	private int geefKeuzeUitMenu() {
		String[] keuzes = {"Voeg wapen toe", "Voeg sleutel toe", "Voeg gebouw toe", "Toon huidig overzicht", "Beëindig deze applicatie"};
		int keuze = 0;

		do
		{
			System.out.println("Kies uit:");
			for(int i = 0; i < keuzes.length; i++) 
				System.out.printf("%d. %s%n", i+1, keuzes[i]);
			try 
			{
				System.out.print("Je keuze is: ");
				keuze = Integer.parseInt(invoer.nextLine());
				
				if(keuze < 1 || keuze > keuzes.length)
					throw new IllegalArgumentException(String.format("Geef een getal tussen %d en %d.", 1, keuzes.length));
			}catch(NumberFormatException e) {
				System.out.println("Voer een geheel getal in.");
				
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}while(keuze < 1 || keuze > keuzes.length);
		return keuze;
	}
}
