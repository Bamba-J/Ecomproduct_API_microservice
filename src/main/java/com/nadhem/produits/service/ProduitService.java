package com.nadhem.produits.service;

import java.util.List;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;

public interface ProduitService {
	void saveProduit(Produit p);
	public Produit returnSaveProduit(Produit p);
	void updateProduit(Long id, Double nPrix);
	public Produit returnUpdateProduit(Produit p);
	public List<Produit> returnAllProduit();
	public Produit returnProduit(Long id); 
	public List <Produit> returnNomProduitContains(String nomProduit);
	public List <Produit> returnProduitCategorieIdCat(Long id);
	void deleteProduit(Long id);
	void deleteAllProduit();
	void getAllProduits();
	void findByNomProduit (String nom);
	void findByNomProduitContains (String nom);
	void findByCategorieIdCat (Long id);
	void findByOrderByNomProduitAsc();
	void findByOrderByPrixProduitDesc();
	void findByNomProduitPrixProduit(String nom, Double prix);
	void findByCategorie (Categorie cat);
	void trierProduitsNomsPrix ();

}
