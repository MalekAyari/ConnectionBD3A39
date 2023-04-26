/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.gui;

import connectionbd3a39.entities.Annonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author GAMERS
 */
public class AnnonceController implements Initializable {

    @FXML
    private Label labelId;
    @FXML
    private Label LabelCreation;
    @FXML
    private Label labelModif;
    @FXML
    private Label labelTitre;
    @FXML
    private TextArea LabelDesc;
    @FXML
    private TextField tfCommentaire;

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
            LabelDesc.setText(annonce.getDescAnnonce());
            labelModif.setText(annonce.getDateModification().toString());
            labelId.setText(annonce.getId().toString());
            LabelCreation.setText(annonce.getDateCreation().toString());
        }

    }

    @FXML
    private void ajouterComm(ActionEvent event) {

    }

}
