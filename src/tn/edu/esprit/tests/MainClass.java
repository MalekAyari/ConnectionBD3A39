/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Personne;
import tn.edu.esprit.services.ServicePersonne;
import tn.edu.esprit.utils.DataSource;

/**
 *
 * @author abdelazizmezri
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ServicePersonne sp = new ServicePersonne();
            
            Personne p1 = new Personne(5,"Aziz", "M");
            Personne p2 = new Personne("Fakhreddine", "Ghalleb");
            
            //sp.ajouter(p1);
            //sp.ajouter2(p2);
            
            //System.out.println(sp.getAll());
            //sp.modifier(p1);
            
            sp.supprimer(7);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}