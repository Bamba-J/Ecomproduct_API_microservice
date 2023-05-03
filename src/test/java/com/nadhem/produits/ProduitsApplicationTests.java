package com.nadhem.produits;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.service.ProduitServiceImpl;
//@#{}[]\<>||

@SpringBootTest
class ProduitsApplicationTests {
	
	@Autowired
	ProduitServiceImpl service ;
	
	@Test	
	public void testCreateProduit(){

		Categorie categorie = new Categorie ();
		categorie.setIdCat(1L);
		Produit prod = new Produit("Sym", 475000.00, categorie);
		service.saveProduit(prod);
	}

	
	@Test
	public void testUpdateProduit(){

		service.updateProduit(23L, 495000.00);
	}
	
	@Test
	public void testDeleteProduit(){
		
		service.deleteProduit(20L);
		
	}
	
	@Test
	public void testDeleteAllProduit(){
		
		service.deleteAllProduit();
	}
	
	@Test
	public void testFindAllProduit(){

		service.getAllProduits();
	}
	
	
	@Test
	public void testFindNomProduit(){

		service.findByNomProduit("Piaggo");
	}
	@Test
	public void testFindNomProduitContain(){

		service.findByNomProduitContains("s");
	}

	@Test
	public void testFindNomProduitPrixProduit(){

		service.findByNomProduitPrixProduit("Liberty", 300000.00);
	}

	@Test
	public void testFindIdProduit(){

		System.out.println(service.returnProduit(23L)); 
	}
	
	@Test
	public void testFindProduitCategorie(){

		Categorie cat = new Categorie();
		cat.setIdCat(21L);
		service.findByCategorie(cat);
	}
	@Test
	public void testFindCategorie(){
		service.findByCategorieIdCat(23L);

	}
	
	@Test
	public void testFindByOrderNomProduit(){

		service.findByOrderByNomProduitAsc();
	}

	@Test
	public void testFindByOrderPrixProduit(){

		service.findByOrderByPrixProduitDesc();
	}
	@Test
	
	public void testtrierProduitsNomPrix(){

		service.trierProduitsNomsPrix();
	}
}
