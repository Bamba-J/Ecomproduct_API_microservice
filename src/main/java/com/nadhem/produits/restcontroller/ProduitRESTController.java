package com.nadhem.produits.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.service.ProduitServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {

	@Autowired
	ProduitServiceImpl service;
	
	@RequestMapping (path ="all", method = RequestMethod.GET)
	public	List<Produit> getAllProduit(){
		
		return service.returnAllProduit();
	
	}
	

	
	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id){
		return service.returnProduit(id);
	} 
	

	@RequestMapping (method = RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit produit){
		return service.returnSaveProduit(produit);
	}
	
	@RequestMapping (method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit){
		produit.setDateCreation(new Date());
		return service.returnUpdateProduit(produit);
	}
	
	@RequestMapping (value= "/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id){
		
		service.deleteProduit(id);
	}
	
	
	
	@RequestMapping (value= "prodscat/{idCat}", method = RequestMethod.GET)
	public List<Produit> getProduitCategorie(@PathVariable("idCat") Long id){
		
		return service.returnProduitCategorieIdCat(id);
	}
	
	
	@RequestMapping (value = "/prodsByName/{nom}", method = RequestMethod.GET)
	public List<Produit> getProduitByNom(@PathVariable("nom") String nomProduit){
		return service.returnNomProduitContains(nomProduit);
	}
}
