package com.springframework.recipe.controllers;

import com.springframework.recipe.domain.Category;
import com.springframework.recipe.domain.UnitOfMeasure;
import com.springframework.recipe.repositories.CategoryRepository;
import com.springframework.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription(("Teaspoon"));
        System.out.println("category id: " + categoryOptional.get().getId());
        System.out.println("unit id: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
