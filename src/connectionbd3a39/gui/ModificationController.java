/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.gui;

import connectionbd3a39.entities.Annonce;
import connectionbd3a39.services.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GAMERS
 */
public class ModificationController implements Initializable {

    @FXML
    public TextField oldTitre;
    @FXML
    private TextField newTitre;
    @FXML
    public TextField oldImg;
    @FXML
    private TextField newImg;
    @FXML
    private TextArea newDesc;
    @FXML
    public TextArea oldDesc;
    @FXML
    private Button btnSave;
    
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    private Date dateCreation;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    private ServiceAnnonce sa = new ServiceAnnonce();

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    private Annonce annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void save(ActionEvent event) {

        try {
            String titre = newTitre.getText();
            String descAnnonce = newDesc.getText();
            Date dateModification = Date.valueOf(LocalDate.now());
            String img = newImg.getText();

            Annonce a = new Annonce(titre, descAnnonce, dateCreation, dateModification, img);

            sa.modifier(a, Id);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AnnonceFXML.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                stage.setScene(scene);
                stage.show();   
            } catch (IOException ex) {
                Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
