package com.octest.models;

public class Utilisateurs {
   private String nom;
   private String prenom;
   private String email;
   private String adresse;
   private String motDePasse;
   private String profile;
   private int Id;
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getMotDePasse() {
			return motDePasse;
		}
		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String prolife) {
			this.profile = prolife;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
   
}
