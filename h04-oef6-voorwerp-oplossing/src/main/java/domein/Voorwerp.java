package domein;

public abstract class Voorwerp implements Draagbaar
{
    private final String naam;
    private double gewicht;
    private int niveau;

    public Voorwerp(String naam, double gewicht, int niveau)
    {
        controleerGewicht(gewicht);
        controleerNiveau(niveau);
         controleerNaam(naam);
        
        this.naam = naam;
        this.niveau = niveau;
        this.gewicht = gewicht;

    }
    public Voorwerp(String naam, double gewicht)
    {
        this(naam,gewicht,1);
    }
     private void controleerNaam(String naam) 
     {
        if (naam == null || naam.trim().isEmpty())
            throw new IllegalArgumentException("Elk voorwerp moet verplicht een naam hebben.");
    }
    private void controleerGewicht(double gewicht)
    {
        if (gewicht < 0 || gewicht >= 1000)
            throw new IllegalArgumentException("Gewicht moet groter of gelijk aan 0 en minder dan 1000 kg zijn");
    }
    private void controleerNiveau(int niveau)
    {
        if (niveau < 1 || niveau > 10)
             throw new IllegalArgumentException("Niveau moet tussen 1 en 10 liggen");
    }
    public void setGewicht(double gewicht)
    {
        controleerGewicht(gewicht);
        this.gewicht = gewicht;
    }
    public void setNiveau(int niveau)
    {
        controleerNiveau(niveau);
        this.niveau = niveau;
    }
    public String getNaam()
    {
        return naam;
    }
    public double getGewicht()
    {
        return gewicht;
    }
    public int getNiveau()
    {
        return niveau;
    }
    @Override
    public String toString()
    {
        return String.format("%s %s met gewicht %.3f kg uit niveau %d",
                this.getClass().getSimpleName(), naam, gewicht, niveau);
    }
}
