package net.local.dddpoc.catalog.application.ports.outbound;

import java.util.Optional;
import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.Category;
import net.local.dddpoc.catalog.application.domain.category.CategoryId;

public interface LoadCategoryPort {
    
    Stream<Category> loadAll();
    Optional<Category> loadById(CategoryId categoryId);
}
