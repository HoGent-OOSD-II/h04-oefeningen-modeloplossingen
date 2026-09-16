package domein;

public class DomeinController
{
	private Thermometer t = new Thermometer();
	
	public void updateTemperatuur(String tempF)
	{
		t.stelAantalGradenIn(tempF);
	}

	public int geefTemperatuurInCelsius()
	{
		return t.converteerNaarCelsius();
	}
}
