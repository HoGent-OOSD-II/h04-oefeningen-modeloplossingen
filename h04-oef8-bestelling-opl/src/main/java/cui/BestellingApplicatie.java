package cui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.Bestelling;
import domein.DomeinController;
import exceptions.BestellingException;

public class BestellingApplicatie {
	private static final String[] keuzes = { "Nieuwe bestelling plaatsen", "Overzicht bestellingen tonen", "Stoppen" };
	private Scanner invoer = new Scanner(System.in);
	private final DomeinController dc;

	public BestellingApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		int keuze;
		do {
			keuze = Menu.geefKeuzeUitMenu(keuzes);
			switch (keuze) {
			case 1 -> maakNieuweBestelling();
			case 2 -> toonBestellingen();
			case 3 -> System.out.println("Tot een volgende keer...");
			}
			System.out.println();
		} while (keuze != 3);
	}

	private void toonBestellingen() {
		List<String> overzicht = dc.geefBestellingen();
		if (overzicht.isEmpty()) {
			System.out.println("Er werden geen bestellingen gevonden.");
			return;
		}
		for (String bestelling : dc.geefBestellingen()) {
			System.out.println(bestelling);
		}
	}

	private void maakNieuweBestelling() {
		boolean bestellingOK = false;
		do {
			try {
				int printers = vraagAantal("Geef aantal printers: ", Bestelling.MAX_PRINTERS);
				int scanners = vraagAantal("Geef aantal scanners: ", Bestelling.MAX_SCANNERS);
				int laptops = vraagAantal("Geef aantal laptops: ", Bestelling.MAX_LAPTOPS);
				dc.voegBestellingToe(printers, laptops, scanners);
				System.out.println("Je bestelling werd geplaatst...\n");
				bestellingOK = true;
			} catch (BestellingException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (!bestellingOK);
	}

	private int vraagAantal(String vraag, int maximum) {
		int aantal = 0;
		boolean invoerOK = false;
		do {
			try {
				System.out.print(vraag);
				aantal = invoer.nextInt();
				if (aantal < 0 || aantal > maximum)
					throw new IllegalArgumentException();
				invoerOK = true;
			} catch (IllegalArgumentException | InputMismatchException e) {
				System.out.println(String.format("Geef een geheel getal tussen 0 en %d", maximum));
				if (e instanceof InputMismatchException)
					invoer.nextLine();
			}
		} while (!invoerOK);
		return aantal;
	}
}
