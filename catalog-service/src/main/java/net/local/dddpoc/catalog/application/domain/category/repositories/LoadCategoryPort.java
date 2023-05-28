package net.local.dddpoc.catalog.application.domain.category.repositories;

import java.util.Optional;
import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;
import net.local.dddpoc.catalog.application.domain.category.entities.CategoryId;

public interface LoadCategoryPort {
    
    Stream<Category> loadAll();
    Optional<Category> loadById(CategoryId categoryId);
}
