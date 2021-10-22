package com.kollector.app.repository;

import com.kollector.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//Categories repository 

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
