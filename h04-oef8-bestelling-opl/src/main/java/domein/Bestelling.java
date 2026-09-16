package domein;

import exceptions.BestellingException;

public class Bestelling {
	public static final int MAX_ARTIKELEN = 8;
	public static final int MAX_PRINTERS = 4;
	public static final int MAX_SCANNERS = 3;
	public static final int MAX_LAPTOPS = 2;
	private int printers, laptops, scanners;

	public Bestelling(int printers, int laptops, int scanners) throws BestellingException {
		int aantalArtikels = printers + laptops + scanners;
		if (aantalArtikels < 1 || aantalArtikels > MAX_ARTIKELEN)
			throw new BestellingException(
					String.format("Bestelling moet minstens 1, maximaal %d artikelen bevatten", MAX_ARTIKELEN));
		setPrinters(printers);
		setLaptops(laptops);
		setScanners(scanners);
	}



	public int getPrinters() {
		return printers;
	}



	public int getLaptops() {
		return laptops;
	}



	public int getScanners() {
		return scanners;
	}



	private void setPrinters(int printers) {
		if (printers < 0 || printers > MAX_PRINTERS)
			throw new IllegalArgumentException(
					String.format("Bestelling mag 0 tot %d printers bevatten", MAX_PRINTERS));
		this.printers = printers;
	}



	private void setLaptops(int laptops) {
		if (laptops < 0 || laptops > MAX_LAPTOPS)
			throw new IllegalArgumentException(String.format("Bestelling mag 0 tot %d laptops bevatten", MAX_LAPTOPS));
		this.laptops = laptops;
	}



	private void setScanners(int scanners) {
		if (scanners < 0 || scanners > MAX_SCANNERS)
			throw new IllegalArgumentException(
					String.format("Bestelling mag 0 tot %d scanners bevatten", MAX_SCANNERS));
		this.scanners = scanners;
	}

	@Override
	public String toString() {
		return String.format("Bestelling van %d printers, %d laptops en %d scanners", printers, laptops, scanners);
	}
}
