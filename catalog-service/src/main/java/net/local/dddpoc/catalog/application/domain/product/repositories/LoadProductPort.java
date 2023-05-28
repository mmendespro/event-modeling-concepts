package net.local.dddpoc.catalog.application.domain.product.repositories;

import java.util.Optional;
import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.product.entities.Product;
import net.local.dddpoc.catalog.application.domain.product.entities.ProductId;

public interface LoadProductPort {
    
    Stream<Product> findAll();
    Optional<Product> findById(ProductId productId);

}
