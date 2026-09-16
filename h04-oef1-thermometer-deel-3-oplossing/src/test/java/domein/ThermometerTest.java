package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ThermometerTest {
	private Thermometer t;

	@BeforeEach
	public void before() {
		t = new Thermometer();
	}

	@Test
	public void maakThermometer_defaultWaardeAantalGraden_maaktObject() {
		Assertions.assertEquals(32, t.getAantalGraden());
	}

	@Test
	public void maakThermometer_aantalGraden15_maaktObject() {
		t.stelAantalGradenIn("15");
		Assertions.assertEquals(15, t.getAantalGraden());
	}

	@Test
	public void converteerNaarCelsius_50F_geeft10C() {
		t.stelAantalGradenIn("50");
		int conversie = t.converteerNaarCelsius();
		Assertions.assertEquals(10, conversie);
	}

	@Test
	public void converteerNaarCelsius_35F_geeft1C() {
		t.stelAantalGradenIn("35");
		int conversie = t.converteerNaarCelsius();
		Assertions.assertEquals(1, conversie);
	}

	@Test
	public void converteerNaarCelsius_0F_werptException() {
		Assertions.assertThrows(IllegalArgumentException.class , () -> t.stelAantalGradenIn("0"));
	}

    @Test
    public void stelAantalGradenIn_niet_getal_geeftException() {
        Assertions.assertThrows(NumberFormatException.class , () -> t.stelAantalGradenIn("a"));
    }
}
