package cui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static Scanner invoer = new Scanner(System.in);

	public static int geefKeuzeUitMenu(String[] keuzes) {
		int keuze = -1;
		boolean invoerOK = false;
		do {
			try {
				toonMenu(keuzes);
				keuze = invoer.nextInt();
				if (keuze < 1 || keuze > keuzes.length)
					throw new IllegalArgumentException(
							String.format("Keuze moet tussen 1 en %d liggen.", keuzes.length));
				invoerOK = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.out.println();
			} catch (InputMismatchException e) {
				System.out.printf("Geef een geheel getal in tussen 1 en %d%n", keuzes.length);

				invoer.nextLine();
			}
		} while (!invoerOK);
		return keuze;
	}

	private static void toonMenu(String[] keuzes) {
		System.out.println("MENU");
		System.out.println("====");
		for (int i = 0; i < keuzes.length; i++) {
			System.out.printf("%d. %s%n", i + 1, keuzes[i]);
		}
		System.out.print("Voer je keuze in: ");
	}
}
