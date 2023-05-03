package com.nadhem.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;

@RepositoryRestResource (path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List <Produit> findByNomProduit (String nom);
	Produit findByIdProduit(Long id);
	List <Produit> findByNomProduitContains (String nom);
	List <Produit> findByCategorieIdCat (Long id);
	List <Produit> findByOrderByNomProduitAsc();
	List <Produit> findByOrderByPrixProduitDesc();
	
	
	@Query ("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List <Produit> findByNomProduitPrixProduit(String nom, Double prix);
	
	@Query("select p from Produit p where p.categorie = ?1 ")
	List <Produit> findByCategorie (Categorie cat);
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
	
	
	
	
}