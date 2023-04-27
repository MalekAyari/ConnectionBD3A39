/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import connectionbd3a39.entities.Annonce;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GAMERS
 */
public class AnnonceCardController implements Initializable {

    @FXML
    private Label labelTitre;
    @FXML
    private Label labelModif;
    @FXML
    private TextArea labelDesc;
    @FXML
    private Button btnDetails;

    private Annonce annonce;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setData(Annonce annonce) {
        this.annonce = annonce;
        if (annonce == null) {
            System.out.println("null");
        } else {
            labelTitre.setText(annonce.getTitre());
            labelDesc.setText(annonce.getDescAnnonce());
            labelModif.setText(annonce.getDateModification().toString());
        }
    }
    
    @FXML
    private void toAnnonce(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Annonce.fxml"));
            Parent root = loader.load();
            AnnonceController ac = loader.getController();
            ac.setData(annonce);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AnnonceCardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
