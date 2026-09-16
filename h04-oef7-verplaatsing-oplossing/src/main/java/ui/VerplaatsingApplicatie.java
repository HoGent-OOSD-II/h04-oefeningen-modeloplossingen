/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author sv964
 */
import domein.DomeinController;

public class VerplaatsingApplicatie
{
    private  DomeinController dc; 

    public VerplaatsingApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }
    
    public void start()
    {
       
        String uitvoer = dc.geefOverzichtAantalDocumenten();
        uitvoer += dc.geefKostenLijst();
        System.out.printf(uitvoer);
    }

}
