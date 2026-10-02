package org.lxrssdev.app.marketec.services;

import lombok.AllArgsConstructor;
import org.lxrssdev.app.marketec.entities.Seller;
import org.lxrssdev.app.marketec.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    //getSeller
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }
    //createSeller
    public void createSeller(String name, String lastName, String username,
                             String password, String controlNumber){
        Seller seller = new Seller();
        seller.setName(name);
        seller.setLastName(lastName);
        seller.setUsername(username);
        seller.setPassword(password);
        seller.setControlNumber(controlNumber);
        sellerRepository.save(seller);
    }
    //deleteSeller
    public void deleteSeller(Long id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("seller doesn't exists!"));
        sellerRepository.delete(seller);
    }
    //updateSeller
    public void updateSeller(Long id, String name, String lastName, String username,
                             String password){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("seller doesnt exists!"));
        seller.setName(name);
        seller.setLastName(lastName);
        seller.setUsername(username);
        seller.setPassword(password);
        sellerRepository.save(seller);
    }

}
