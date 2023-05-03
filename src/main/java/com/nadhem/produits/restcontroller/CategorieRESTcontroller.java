package com.nadhem.produits.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.repos.CategorieRepository;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTcontroller {
	
	@Autowired
	private CategorieRepository categorierepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categorie> findAll(){
		return this.categorierepository.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id){
		return this.categorierepository.findByIdCat(id);
	}

}
