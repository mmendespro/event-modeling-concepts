package net.local.dddpoc.catalog.application.ports.outbound;

import net.local.dddpoc.catalog.application.domain.product.Product;

public interface SaveProductPort {
    
    void save(Product product);
    void categorize(String categoryId, String productId);
}
