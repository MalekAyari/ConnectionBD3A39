/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.gui;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import connectionbd3a39.entities.Annonce;
import connectionbd3a39.services.ServiceAnnonce;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author GAMERS
 */
public class AnnonceFXMLController implements Initializable {

    @FXML
    private Button btnCreer;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfImg;
    @FXML
    private TextArea taDesc;
    @FXML
    private TableView<Annonce> tvAnnonce;
    @FXML
    private TableColumn<Annonce, Integer> tvId;
    @FXML
    private TableColumn<Annonce, String> tvTitre;
    @FXML
    private TableColumn<Annonce, String> tvDesc;
    @FXML
    private TableColumn<Annonce, Date> tvDC;
    @FXML
    private TableColumn<Annonce, Date> tvDM;
    @FXML
    private TableColumn<Annonce, Boolean> tvAction;

    ServiceAnnonce sa = new ServiceAnnonce();
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnModif;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnModif.setDisable(true);
        btnSupp.setDisable(true);
        
        tvId.setCellValueFactory(new PropertyValueFactory<Annonce, Integer>("id"));
        tvTitre.setCellValueFactory(new PropertyValueFactory<Annonce, String>("titre"));
        tvDesc.setCellValueFactory(new PropertyValueFactory<Annonce, String>("descAnnonce"));
        tvDC.setCellValueFactory(new PropertyValueFactory<Annonce, Date>("dateCreation"));
        tvDM.setCellValueFactory(new PropertyValueFactory<Annonce, Date>("dateModification"));
        tvAction.setCellValueFactory(new PropertyValueFactory<Annonce, Boolean>(""));
        tvAction.setCellFactory(CheckBoxTableCell.forTableColumn(tvAction));
        //tvAction.setCellValueFactory(new PropertyValueFactory<Annonce,void>);

        try {
            sa.getAll();
            ObservableList<Annonce> list = FXCollections.observableArrayList(sa.getAll());
            tvAnnonce.setItems(list);

        } catch (SQLException e) {
            Logger.getLogger(AnnonceFXMLController.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @FXML
    private void ajouter(ActionEvent event) {
        try {
            String titre = tfTitre.getText();
            String descAnnonce = taDesc.getText();
            Date dateCreation = Date.valueOf(LocalDate.now());
            Date dateModification = Date.valueOf(LocalDate.now());
            String img = tfImg.getText();

            Annonce a = new Annonce(titre, descAnnonce, dateCreation, dateModification, img);

            sa.ajouter(a);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsFXML.fxml"));            
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
