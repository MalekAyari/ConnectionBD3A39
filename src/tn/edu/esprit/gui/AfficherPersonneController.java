/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author abdelazizmezri
 */
public class AfficherPersonneController implements Initializable {

    @FXML
    private Label lblNom;
    @FXML
    private Label lblPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setNom(String nom){
        lblNom.setText(nom);
    }
    
    public void setPrenom(String prenom){
        lblPrenom.setText(prenom);
    }

    
}