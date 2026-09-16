package domein;

public class Wapen extends Voorwerp
{
    private int kracht;
    private boolean gebruikt;

    public Wapen(String naam, double gewicht, int niveau, int kracht, boolean gebruikt)
    {
        super(naam, gewicht);
        controleerNiveau(niveau);
        controleerKracht(kracht);
        super.setNiveau(niveau);
        this.kracht = kracht;
        this.gebruikt = gebruikt;
    }
    private void controleerNiveau(int niveau)
    {
        if (niveau > 5)
            throw new IllegalArgumentException("Wapens zijn enkel beschikbaar t.e.m. niveau 5!");
    }
    private void controleerKracht(int kracht)
    {
        if (kracht < 0)
            throw new IllegalArgumentException("Kracht moet een positief getal zijn!");
    }
    public void setKracht(int kracht)
    {
        controleerKracht(kracht);
        this.kracht = kracht;
    }

    public void setGebruikt(boolean gebruikt)
    {
        this.gebruikt = gebruikt;
    }
    @Override
    public void setNiveau(int niveau)
    {
        controleerNiveau(niveau);
        super.setNiveau(niveau);
    }
    public int getKracht()
    {
        return kracht;
    }
    public boolean isGebruikt()
    {
        return gebruikt;
    }
    @Override
    public String toString()
    {
        return String.format("%s en met kracht %d %s gebruikt.",
                super.toString(), kracht, gebruikt ? "al" : "nog niet");
    }

     @Override
    public boolean isDraagbaar()
    {
        return true;
    }
}
