package org.sos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Categorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idCat;
private String nomCat;
private String codeCat;
public Long getIdCat() {
	return idCat;
}
public void setIdCat(Long idCat) {
	this.idCat = idCat;
}
public String getNomCat() {
	return nomCat;
}
public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}
public String getCodeCat() {
	return codeCat;
}
public void setCodeCat(String codeCat) {
	this.codeCat = codeCat;
}
public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}
public Categorie(String nomCat, String codeCat) {
	super();
	this.nomCat = nomCat;
	this.codeCat = codeCat;
}

}
