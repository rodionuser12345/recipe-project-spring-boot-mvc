package com.rodionspringframework.recipeprojectspringbootmvc.repositories;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
