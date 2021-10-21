package com.kollector.app.service;

import com.kollector.app.model.Product;
import com.kollector.app.model.ProductSell;
import com.kollector.app.repository.ProductSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSellService {
    @Autowired
    ProductSellRepository productSellRepository;
    public List<ProductSell> getAllProduct(){
        return productSellRepository.findAll();
    }
    public void addProduct(ProductSell productSell){
        productSellRepository.save(productSell);
    }
    //public void removeProductSellById(long id){
    //    productSellRepository.deleteById(id);
    //}
    public Optional<ProductSell> getProductSellById(long id){
        return productSellRepository.findById(id);
    }
    public List<ProductSell> getAllProductSellByCategoryId(int id){
        return productSellRepository.findAllSellByCategory_Id(id);
    }

}
