package org.lxrssdev.app.marketec.services;

import lombok.AllArgsConstructor;
import org.lxrssdev.app.marketec.entities.Category;
import org.lxrssdev.app.marketec.entities.Product;
import org.lxrssdev.app.marketec.entities.ProductImage;
import org.lxrssdev.app.marketec.entities.Seller;
import org.lxrssdev.app.marketec.repositories.ProductRepository;
import org.lxrssdev.app.marketec.repositories.SellerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {


    private final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    //get all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //product by id
    public Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id: " + id + " does not exists!"));
    }

    //create product final
    public void createProduct(String name, String description, BigDecimal price, List<ProductImage> images, Category category, Seller seller){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setUrlImages(images);
        product.setCategory(category);
        product.setSeller(seller);
        productRepository.save(product);
        log.info("product saved!");

    }
   //create product for tests
   public void createProductTest(String name, String description, BigDecimal price, Category category){
       Product product = new Product();
       product.setName(name);
       product.setDescription(description);
       product.setPrice(price);
       product.setCategory(category);
       product.setSeller(sellerRepository.findById(1L).orElseThrow(() -> new RuntimeException("seller doesnt exists!")));
       productRepository.save(product);
       log.info("product TEST saved!");
   }


    //updateProduct
    public void updateProduct(Long id, String name, String description, BigDecimal price, List<ProductImage> images, Category category){
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id: " +id+ " does not exists!"));

        productToUpdate.setName(name);
        productToUpdate.setDescription(description);
        productToUpdate.setPrice(price);
        productToUpdate.setUrlImages(images);
        productToUpdate.setCategory(category);
        productRepository.save(productToUpdate);
    }

    //deleteProduct
    public void deleteProduct(Long id){
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id: " +id + " does not exists!"));

        productRepository.delete(productToDelete);

    }

    //findByName
    public List<Product> findProductByName(String name){
        return productRepository.findByName(name);
    }
    //findByCategory
    public List<Product> findByCategory(Category category){
        return productRepository.findByCategory(category);
    }

    //findBySeller
    public List<Product> findBySeller(Seller seller){
        return productRepository.findBySeller(seller);
    }


}
