package com.nadhem.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired //permet d' injecter des dépendances
	ProduitRepository produitRepository;
	
	@Override
	public void saveProduit(Produit p) {
		produitRepository.save(p);
	}
	@Override
	public Produit returnSaveProduit(Produit p){
		return 	produitRepository.save(p);
	}

	@Override
	public void updateProduit(Long id, Double nPrix) {
		Produit p = produitRepository.findById(id).get();
		p.setPrixProduit(nPrix);
		produitRepository.save(p);
	}
	@Override
	public Produit returnUpdateProduit(Produit p) {
		
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		Produit p = produitRepository.findById(id).get();
		produitRepository.delete(p);
		
	}
	
	@Override
	public void deleteAllProduit() {
		produitRepository.deleteAll();
		
	}


	@Override
	public void getAllProduits() {
		
		List < Produit > produits = produitRepository.findAll();
		for (Produit p:produits){
			System.out.println(p.toString());
		}
	}
	@Override
	public List<Produit> returnAllProduit(){
		return produitRepository.findAll();
	}

	
	public Produit returnProduit(Long id){
		return produitRepository.findByIdProduit(id);
	}
	
	
	@Override
	public void findByNomProduit (String nom) {
		List < Produit > produits = produitRepository.findByNomProduit(nom);
		for (Produit p:produits){
			System.out.println(p.toString());
		}
		
	}

	@Override
	public void findByNomProduitContains(String nom) {
		List < Produit > produits = produitRepository.findByNomProduitContains(nom);
		for (Produit p:produits){
			System.out.println(p.toString());
		}
	}
	@Override
	public List <Produit> returnNomProduitContains(String nomProduit){
		return produitRepository.findByNomProduitContains(nomProduit);
	}
	
	@Override
	public void findByCategorieIdCat(Long id) {
		List<Produit> produits  = produitRepository.findByCategorieIdCat(id);
		for(Produit produit : produits){
			System.out.println(produit);
		}
	}
	@Override
	public List <Produit> returnProduitCategorieIdCat(Long id) {
		List<Produit> produits  = produitRepository.findByCategorieIdCat(id);
		return produits;
	}

	@Override
	public void findByOrderByNomProduitAsc() {
		List<Produit> produits = produitRepository.findByOrderByNomProduitAsc();
		for(Produit produit: produits){
			System.out.println(produit);
		}
	}

	@Override
	public void findByOrderByPrixProduitDesc() {
		List<Produit> produits = produitRepository.findByOrderByPrixProduitDesc();
		for(Produit produit: produits){
			System.out.println(produit);
		}
	}

	@Override
	public void findByNomProduitPrixProduit(String nom, Double prix) {
		List<Produit> produits  = produitRepository.findByNomProduitPrixProduit(nom, prix);
		for(Produit produit : produits){
			System.out.println(produit);
		}
	}

	@Override
	public void findByCategorie(Categorie cat) {
		
		List<Produit> produits  = produitRepository.findByCategorie(cat);
		for(Produit p : produits){
			
			System.out.println(p);
		
		}
	}

	@Override
	public void trierProduitsNomsPrix() {		
		
		List <Produit> produits = produitRepository.trierProduitsNomsPrix();
		for (Produit produit : produits){
			System.out.println(produit);
		}
	}

	
	

}
