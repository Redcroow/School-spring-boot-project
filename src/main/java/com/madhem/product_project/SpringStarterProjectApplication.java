package com.madhem.product_project;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import com.madhem.product_project.entities.Produit;
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
        Produit prod = new Produit("PC Acer",2700.500,new Date());
        produitRepository.save(prod);
    }
    @Test
    public void testFindProduct() {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }
    @Test
    public void testUpdateProduct() {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(4000.0);
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
}
