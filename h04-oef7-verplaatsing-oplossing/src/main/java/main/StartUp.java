package main;


import domein.DomeinController;
import ui.VerplaatsingApplicatie;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sv964
 */
public class StartUp
{
    public static void main(String args[])
    {
        try
        {
        	DomeinController dc = new DomeinController();
        	new VerplaatsingApplicatie(dc).start();
        }
       
        catch(IllegalArgumentException e)
        {
             System.out.println(e.getMessage());
        }
    }
    
}
