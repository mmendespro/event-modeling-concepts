package net.local.dddpoc.catalog.application.domain.product.entities;

import net.local.dddpoc.catalog.application.domain.primitives.Money;

public interface Product {
    
    ProductId id();

    Title title();

    Description description();

    Money price();

}
