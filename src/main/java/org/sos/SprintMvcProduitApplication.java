package org.sos;

import java.util.List;

import org.sos.dao.ProduitRepository;
import org.sos.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class SprintMvcProduitApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SprintMvcProduitApplication.class, args);
		/*
		ProduitRepository dao=ctx.getBean(ProduitRepository.class);
		
		dao.save(new Produit("LX654",78600.0));
		dao.save(new Produit("HLX",54300.0));
		dao.save(new Produit("ALX",1200.0));
		dao.save(new Produit("HP870",3400.0));
		 List<Produit> prods=dao.findAll();
		 System.out.println("---------------------------");
		 System.out.println("Listes des Produits:");
		 for(Produit p:prods)
		 {
			 System.out.println(p.getDesignation()+"--"+p.getPrix());
		 }
		 System.out.println("---------------------------");
		 System.out.println("Produits de la page 0");
		 Page<Produit> pageProduits=dao.findAll(new PageRequest(0,4));
		 System.out.println("Page Courante :"+pageProduits.getNumber());
		 System.out.println("Nombre de Page :"+pageProduits.getTotalPages());
		 System.out.println("Nombre de Produit"+pageProduits.getTotalElements());
		 List<Produit> prods2=pageProduits.getContent();
		 for(Produit p:prods2)
		 {
			 System.out.println(p.getDesignation()+"--"+p.getPrix());
		 }
		 System.out.println("---------------------------");
		 System.out.println("Chercher Les Produits");
		 Page<Produit> prods3=dao.chercherProduit("%L%",new PageRequest(0,4));
		 for(Produit p:prods3.getContent())
		 {
			 System.out.println(p.getDesignation()+"--"+p.getPrix());
		 }*/
	}
}
