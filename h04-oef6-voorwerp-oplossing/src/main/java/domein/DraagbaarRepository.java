/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sv964
 */
public class DraagbaarRepository {

    private final List<Draagbaar> collectie;

    public DraagbaarRepository() {
        collectie = new ArrayList<>();
    }

    public void voegDraagbaarItemToe(Draagbaar item) {
        collectie.add(item);
    }

    public String geefOverzicht() {
        if (collectie.isEmpty()) {
            return "collectie is leeg\n";
        }

        String resul = "";
        for (Draagbaar item : collectie) {
            resul += item + "\n\n";
        }
        return resul;
    }

}
