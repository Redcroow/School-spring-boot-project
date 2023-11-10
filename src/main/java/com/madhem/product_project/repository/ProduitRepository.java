package com.madhem.product_project.repository;

import com.madhem.product_project.entities.Categorie;
import com.madhem.product_project.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

    @Query("select p from Produit p where p.nomProduit like concat('%', :nomSearch, '%') and p.prixProduit > :prixMinimum")
    List<Produit> findByNomContainNPrix (@Param("nomSearch") String nom, @Param("prixMinimum") Double prix);

    @Query("select p from Produit p where p.categorie.nomCat = :nomCat")
    List<Produit> findByCategorie(@Param("nomCat") String nomCat);
}