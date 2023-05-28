package net.local.dddpoc.catalog.application.domain.product.repositories;

import net.local.dddpoc.catalog.application.domain.product.entities.Product;

public interface SaveProductPort {
    
    void save(Product product);
    void categorize(String categoryId, String productId);
}
