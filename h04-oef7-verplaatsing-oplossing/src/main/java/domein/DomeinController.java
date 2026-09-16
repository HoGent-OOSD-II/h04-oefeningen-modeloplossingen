/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;

/**
 *
 * @author sv964
 */
public class DomeinController
{
    private final KostenRepository kr;
	
    public DomeinController()
    {
            kr = new KostenRepository();
    }
        
     public String geefOverzichtAantalDocumenten()
    {
        return kr.geefOverzichtAantalDocumenten();
    }
    
     public String geefKostenLijst()
     {
         return kr.geefKostenLijst();
     }
     
}
