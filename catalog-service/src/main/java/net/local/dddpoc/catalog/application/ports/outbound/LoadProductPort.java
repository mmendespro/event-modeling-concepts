package net.local.dddpoc.catalog.application.ports.outbound;

import java.util.Optional;
import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.domain.product.ProductId;

public interface LoadProductPort {
    
    Stream<Product> findAll();
    Optional<Product> findById(ProductId productId);

}
