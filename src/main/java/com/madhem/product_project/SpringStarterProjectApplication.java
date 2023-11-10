package com.madhem.product_project;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import com.madhem.product_project.entities.Produit;
import com.madhem.product_project.entities.Categorie;
import com.madhem.product_project.repository.ProduitRepository;

@SpringBootApplication
public class SpringStarterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStarterProjectApplication.class, args);
    }

}
@SpringBootTest
class ProduitsApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;

    @Test
    public void testCreateProduct() {
        Produit prod = new Produit("Iphone 14 Pro Max",1499.900,new Date());
        produitRepository.save(prod);
    }
    @Test
    public void testFindProduct() {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }
    @Test
    public void testUpdateProduct() {
        Produit p = produitRepository.findById(5L).get();
        p.setNomProduit("Iphone X Pro Max");
        produitRepository.save(p);
    }
    @Test
    public void testDeleteProduct() {
        produitRepository.deleteById(1L);;
    }
    @Test
    public void testListerToosProducts() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByNomProduit() {
        List<Produit> prods = produitRepository.findByNomProduit("Iphone X");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByNomProduitContains () {
        List<Produit> prods=produitRepository.findByNomProduitContains("iphone");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testfindByNomContainNPrix() {
        List<Produit> prods = produitRepository.findByNomContainNPrix("Iphone X", 1000.0);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testfindByCategorie() {
        List<Produit> prods = produitRepository.findByCategorie("Telephone");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void findByCategorieIdCat() {
        List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testfindByOrderByNomProduitAsc() {
        List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
    @Test
    public void testTrierProduitsNomsPrix() {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
}
