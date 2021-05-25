package com.rodionspringframework.recipeprojectspringbootmvc.controllers;


import com.rodionspringframework.recipeprojectspringbootmvc.dto.RecipeDto;
import com.rodionspringframework.recipeprojectspringbootmvc.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable Long id, Model model) {

        model.addAttribute("recipe", recipeService.findById(id));

        return "recipe/show";

    }

    @GetMapping("/recipe/new")
    public String createRecipe(Model model) {

        model.addAttribute("recipe", new RecipeDto());

        return "recipe/recipeform";
    }

    @PostMapping("/recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeDto recipeDto) {
        return "redirect:/recipe/show/" + recipeService.saveRecipe(recipeDto).getId();
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model){

        model.addAttribute("recipe", recipeService.findRecipeDtoById(id));

        return  "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable Long id){

        recipeService.deleteById(id);

        return "redirect:/";

    }
}
