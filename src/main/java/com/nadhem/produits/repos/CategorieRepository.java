package com.nadhem.produits.repos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nadhem.produits.entities.Categorie;

@RepositoryRestResource (path = "cat")
@CrossOrigin ("http://localhost:4200/")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	List<Categorie> findByNomCat(String nom);

	Categorie findByIdCat (Long id);
	
}
