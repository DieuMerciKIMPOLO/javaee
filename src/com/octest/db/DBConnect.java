package com.octest.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.octest.models.Utilisateurs;
import com.octest.models.LoginAuthen;
public class DBConnect {
    private Connection connexion;
    private String message;
    private String error;
    
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	public Utilisateurs recupererUtilisateur(int id) {
        Utilisateurs User = new Utilisateurs();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            //resultat = statement.executeQuery("SELECT *  FROM utilisateur;");
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, nom,prenom, email, profile,adresse FROM utilisateur WHERE id=?");
            preparedStatement.setInt(1, id);
            resultat= preparedStatement.executeQuery();
            // Récupération des données
            while (resultat.next()) {
            	Utilisateurs utilisateur = new Utilisateurs();
                String prenom = resultat.getString("prenom");
                utilisateur.setNom(resultat.getString("nom"));
                utilisateur.setPrenom(resultat.getString("prenom"));
                utilisateur.setId(resultat.getInt("id"));
                utilisateur.setAdresse(resultat.getString("adresse"));
                utilisateur.setEmail(resultat.getString("email"));
                utilisateur.setProfile(resultat.getString("profile"));
                User=utilisateur;
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            	
            }
        }
        
        return User;
    }
	public List<Utilisateurs> recupererUtilisateurs() {
        List<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT *  FROM utilisateur;");
            // Récupération des données
            while (resultat.next()) {
            	Utilisateurs utilisateur = new Utilisateurs();
                String prenom = resultat.getString("prenom");
                utilisateur.setNom(resultat.getString("nom"));
                utilisateur.setPrenom(resultat.getString("prenom"));
                utilisateur.setId(resultat.getInt("id"));
                utilisateur.setAdresse(resultat.getString("adresse"));
                utilisateur.setEmail(resultat.getString("email"));
                utilisateur.setProfile(resultat.getString("profile"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            	
            }
        }
        
        return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root2", "dieumerci1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Utilisateurs> LoginAuthen(LoginAuthen loginAuthen) {
    	List<Utilisateurs> UsersList = new ArrayList<Utilisateurs>();
    	loadDatabase();
    	ResultSet resultat = null;
    	Statement statement =null;
    	try {
            statement = connexion.createStatement();

            // Exécution de la requête
            //resultat = statement.executeQuery("SELECT  id, nom,prenom, email, profile,adresse FROM utilisateur WHERE email='"+loginAuthen.getEmail()+"' and motdepasse='"+loginAuthen.getMotDePasse()+"';");
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, nom,prenom, email, profile,adresse FROM utilisateur WHERE email=? and  motdepasse=?");
            preparedStatement.setString(1, loginAuthen.getEmail());
            preparedStatement.setString(2, loginAuthen.getMotDePasse());
            resultat= preparedStatement.executeQuery();
            while(resultat.next()) {
            	Utilisateurs User =new Utilisateurs();
            	User.setAdresse(resultat.getString("adresse"));
            	User.setNom(resultat.getString("nom"));
            	User.setPrenom(resultat.getString("prenom"));
            	User.setEmail(resultat.getString("email"));
            	User.setProfile(resultat.getString("profile"));
            	User.setId(resultat.getInt("id"));
            	UsersList.add(User);
            }
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return UsersList;
    }
    
    public void removeItem(int id) {
    	loadDatabase();
    	ResultSet resultat = null;
    	Statement statement =null;
    	try {
            statement = connexion.createStatement();

            // Exécution de la requête
            //resultat = statement.executeQuery("SELECT  id, nom,prenom, email, profile,adresse FROM utilisateur WHERE email='"+loginAuthen.getEmail()+"' and motdepasse='"+loginAuthen.getMotDePasse()+"';");
            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE  FROM utilisateur WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void ajouterUtilisateur(Utilisateurs utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(nom, prenom, email, adresse, motdepasse) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getAdresse());
            preparedStatement.setString(5, utilisateur.getMotDePasse());
            preparedStatement.executeUpdate();
            this.setMessage("L'enregistrement a ete sauvegarder avec success!!");
        } catch (SQLException e) {
            e.printStackTrace();
            this.setError("Probleme de base de donnees!!");
        }
    }
    
    public void updateUser(Utilisateurs utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE utilisateur SET nom= ?, prenom= ?, email= ? adresse= ? WHERE id= ?;");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getAdresse());
            preparedStatement.setInt(5, utilisateur.getId());
            preparedStatement.executeUpdate();
            this.setMessage("La modification a ete sauvegarder avec success!!");
        } catch (SQLException e) {
            e.printStackTrace();
            this.setError("Probleme de base de donnees!!");
        }
    }
}