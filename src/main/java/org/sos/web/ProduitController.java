package org.sos.web;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.sos.dao.ProduitRepository;
import org.sos.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	/*
	 * @Autowired permet de faire l'injection de dependance avec spring
	 * Quand on met autowired on demande a spring cherche moi un object qui implemente produitRepository
	 * tu vas l injecter dans cette classe
	 */
	@Autowired
    private ProduitRepository produitRepository;//on a besoin de ca pour avoir acces a la couche metier
    /*
     * pour acceder a cette methode je vais utiliser une annotation qui s'appele @RequestMapping
     * ca veut dire quoi?si je tape http:localhost:8080/index c est la methode index qui s excutera
     * si on veut specifier la methode qui sera utilisee on tape method=RequestMethod.Get ou POst
     * la on imposse la methode
     */
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String Accueil(Model model,@RequestParam(name="page") int page)
    {
    	System.out.println("nombre de produit:");
    	//List<Produit> produits=produitRepository.findAll();
    	Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(page,5));
    	model.addAttribute("pageproduit",pageProduits);
    	model.addAttribute("pageCourant",page);
    	int[] pages=new int [pageProduits.getTotalPages()];
    	for(int i=0;i<pages.length;i++) pages[i]=i;
    	model.addAttribute("pages",pages);
    	return "produits";
    }
    
    @RequestMapping(value="/chercher",method=RequestMethod.GET)
    public String Chercher(Model model,
    		@RequestParam(name="motcle",defaultValue="") String motcle,
    		@RequestParam(name="page",defaultValue="0")int page)
    {
    	System.out.println("nombre de produit:");
    	//List<Produit> produits=produitRepository.findAll();
    	Page<Produit> pageProduits=produitRepository.chercherProduit("%"+motcle+"%",new PageRequest(page, 5));
    	model.addAttribute("pageproduit",pageProduits);
    	model.addAttribute("pageCourant",page);
    	model.addAttribute("motcle",motcle);
    	int[] pages=new int [pageProduits.getTotalPages()];
    	for(int i=0;i<pages.length;i++) pages[i]=i;
    	model.addAttribute("pages",pages);
    	return "produits";
    }
    @RequestMapping(value="/form")
    public String formProduit(Model model)
    {
    	model.addAttribute("produit",new Produit());
    	return "formProduit";
    }
    @RequestMapping(value="/saveProduit",method=RequestMethod.POST)
    /*
     * @Valid veut dire que on demande a spring quand il va stocker les données dans produit il va 
     * faire la validation c'est-a- dire il va analyser les anotations est ce q les données respectent
     * les données definies avec les annotations?s il y a les erreurs spring va stocker les erreurs
     * dans un object BindingResult
     */ 
    public String save(Model model,@Valid Produit p,BindingResult bindingResult)
    {
    	if(bindingResult.hasErrors())
    	{
    		return "formProduit";
    	}
    	produitRepository.save(p);
    	model.addAttribute("produit",p);
    	return "confirmation";
    }
}
