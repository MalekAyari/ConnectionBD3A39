/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import connectionbd3a39.entities.Annonce;
import connectionbd3a39.services.ServiceAnnonce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author GAMERS
 */
public class HomePageController implements Initializable {

    @FXML
    private HBox cardBoxUpdates;
    @FXML
    private HBox cardBoxAnnonces;
    @FXML
    private Label linkVoirAnnonces;

    private ServiceAnnonce sa = new ServiceAnnonce();

    private List<Annonce> rs = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linkVoirAnnonces.setOnMouseEntered(e -> {
            linkVoirAnnonces.setUnderline(true);
        });
        linkVoirAnnonces.setOnMouseExited(e -> {
            linkVoirAnnonces.setUnderline(false);
        });

        try {
            rs = sa.getAll();
            int i = 0;
            for (Annonce annonce : rs) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("AnnonceCard.fxml"));
                HBox cardBox = loader.load();
                AnnonceCardController afc = loader.getController();
                afc.setData(annonce);
                cardBoxAnnonces.getChildren().add(cardBox);
                if (i == 9) {
                    break;
                } else {
                    i++;
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void toAnnonceCatalogue(MouseEvent event) {

    }

}
