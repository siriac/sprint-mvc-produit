package org.sos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Produit implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idProduit;
@NotNull
@Size(min=5,max=12)
private String designation;
@DecimalMin(value="100") //le prix ne doit pas etre inferieur a 100
private Double prix=0.0;
public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
public Produit(String designation, Double prix) {
	super();
	this.designation = designation;
	this.prix = prix;
}

}
