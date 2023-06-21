package net.local.dddpoc.catalog.application.valueObjects;

import net.local.dddpoc.catalog.application.domain.primitives.Description;
import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.domain.product.ProductId;

public record InputProduct(ProductId id, Title title, Description description, Money price) implements Product {}
