package net.local.dddpoc.catalog.application.domain.category.repositories;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;

public interface SaveCategoryPort {
    void save(Category category);
}
