package net.local.dddpoc.catalog.application.ports.outbound;

import java.util.Optional;
import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.domain.product.ProductId;

public interface LoadProductPort {
    
    Stream<Product> findAll();
    Stream<Product> findByCategory(CategoryId categoryId);
    Optional<Product> findById(ProductId productId);

}
