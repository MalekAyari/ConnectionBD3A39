/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionbd3a39.services;

import connectionbd3a39.entities.Annonce;
import connectionbd3a39.entities.Commentaire;
import connectionbd3a39.tools.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMERS
 */
public class ServiceCommentaire {
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(Commentaire a, int id) throws SQLException{
        String req = "INSERT INTO commentaire (titre,description,date_creation,date_modification,votes, annonce_id) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement st = cnx.prepareStatement(req);
        
        st.setString(1, a.getTitre());
        st.setString(2, a.getContenu());
        st.setDate(3, a.getDateCreation());
        st.setDate(4, a.getDateModification());
        st.setInt(5, a.getVotes());
        st.setInt(6, id);
        
        st.execute();
    }
    
    public void modifier(Commentaire c, int id) throws SQLException {
        try {
            String req = "UPDATE commentaire SET titre=?, description=?, date_creation=? , date_modification=?, votes=? WHERE id="+id;
            
            PreparedStatement st = cnx.prepareStatement(req);
        
            st.setString(1, c.getTitre());
            st.setString(2, c.getContenu());
            st.setDate(3, c.getDateCreation());
            st.setDate(4, c.getDateModification());
            st.setInt(7, c.getVotes());
            
            st.executeUpdate();
            System.out.println("Votre commentaire a été modifiée avec succés");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(int id) throws SQLException {

        try {
            String req = "delete from commentaire where Id=" + id;
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate();

            System.out.println("Votre commentaire a été supprimée aves succés");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Commentaire> getAll() throws SQLException{
        List<Commentaire> list = new ArrayList<>();
        
        String req = "select * from commentaire";
        
        Statement st = cnx.createStatement();
        
        ResultSet set = st.executeQuery(req);
        
        while(set.next()){
            int id = set.getInt("id");
            String titre = set.getString(2);
            String contenu = set.getString(3);
            Date dateCreation = set.getDate(4);
            Date dateModification = set.getDate(5);
            int votes = set.getInt(7);
            
            Commentaire c = new Commentaire(id, titre, contenu, dateCreation, dateModification, votes);
            list.add(c);
        }
        
        
        return list;
    }

    public Commentaire getOneById(int id) throws SQLException{
        try {

            String req = "SELECT * FROM commentaire WHERE `Id`="+ id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commentaire c = new Commentaire();
                c.setId(rs.getInt(1));
                c.setTitre(rs.getString("titre"));
                c.setContenu(rs.getString("contenu"));
                c.setDateCreation(rs.getDate("date_creation"));
                c.setDateModification(rs.getDate("date_modification"));
                c.setVotes(rs.getInt("votes"));
                
             return c;
            }

        } catch (SQLException ex) {
            System.err.println("ex.getMessage()");
        }
        return null;
    }
}