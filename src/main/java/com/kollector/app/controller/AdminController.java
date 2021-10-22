package com.kollector.app.controller;

import com.kollector.app.model.Product;
import com.kollector.app.service.CategoryService;
import com.kollector.app.dto.ProductDTO;
import com.kollector.app.model.Category;
import com.kollector.app.service.ProductService;
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

//Controller classes for admin.
//Various methods relating to the admin user including url mappings.
//Methods for getting and posting categories and cards to database

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category")Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else
            return "404";
    }

    // Product Section
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setCard_name(productDTO.getCard_name());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategory()).get());
        product.setRarity(productDTO.getRarity());
        product.setDescription(productDTO.getDescription());
        product.setSet(productDTO.getSet());
        product.setCondition(productDTO.getCondition());
        product.setMultiverse_id(productDTO.getMultiverse_id());
        product.setArtist(productDTO.getArtist());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID=file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }else{
            imageUUID = imgName;
        }
        product.setImage_url(imageUUID);
        productService.addProduct(product);


        return "redirect:/admin/products";

    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable long id, Model model){
            Product product = productService.getProductById(id).get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setCard_name(product.getCard_name());
            productDTO.setCategory(product.getCategory().getId());;
            productDTO.setRarity(product.getRarity());
            productDTO.setDescription(product.getDescription());
            productDTO.setArtist((product.getArtist()));
            productDTO.setMultiverse_id(product.getMultiverse_id());
            productDTO.setSet(product.getSet());
            productDTO.setImage_url(product.getImage_url());

            model.addAttribute("categories",categoryService.getAllCategory());
            model.addAttribute("productDTO",productDTO);
            return "productsAdd";
    }

}
