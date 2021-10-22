package com.kollector.app.controller;

import com.kollector.app.dto.ProductSellDTO;
import com.kollector.app.model.Category;
import com.kollector.app.model.ProductSell;
import com.kollector.app.service.CategoryService;
import com.kollector.app.service.ProductSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

//Controller class for seller page
//Methods similar to the admim controller.
//Methods for handling HTTP post and get requests with the provided URI expression.

@Controller
public class SellerController {
    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductSellService productSellService;
    // Product Section
    @GetMapping("/productsSell")
    public String productGet(Model model){
        model.addAttribute("productSellDTO", new ProductSell());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsSell";
    }

    @PostMapping("/productsSell")
    public String productPost(@ModelAttribute("productSellDTO")ProductSellDTO productSellDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {

        ProductSell productSell = new ProductSell();
        productSell.setId(productSellDTO.getId());
        productSell.setCard_name(productSellDTO.getCard_name());
        productSell.setCategory(categoryService.getCategoryById(productSellDTO.getCategory()).get());
        productSell.setUsd_price(productSellDTO.getUsd_price());
        productSell.setCondition(productSellDTO.getCondition());
        productSell.setMultiverse_id(productSellDTO.getMultiverse_id());
        productSell.setUser_email(productSellDTO.getUser_email());
        productSell.setImage_url(productSellDTO.getImage_url());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID=file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }else{
            imageUUID = imgName;
        }
        productSell.setImage_url(imageUUID);
        productSellService.addProduct(productSell);

        return "redirect:/buy";


}
}
