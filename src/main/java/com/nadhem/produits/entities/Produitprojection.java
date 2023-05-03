package com.nadhem.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Produit.class })
public interface Produitprojection {

	public String getNomProduit(); 
	
}
