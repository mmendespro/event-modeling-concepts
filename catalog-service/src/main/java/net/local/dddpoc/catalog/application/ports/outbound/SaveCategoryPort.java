package net.local.dddpoc.catalog.application.ports.outbound;

import net.local.dddpoc.catalog.application.domain.category.Category;

public interface SaveCategoryPort {
    void save(Category category);
}
