package net.local.dddpoc.catalog.application.domain.product;

import net.local.dddpoc.catalog.application.domain.primitives.Description;
import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.primitives.Title;

public interface Product {
    
    ProductId id();

    Title title();

    Description description();

    Money price();

}
