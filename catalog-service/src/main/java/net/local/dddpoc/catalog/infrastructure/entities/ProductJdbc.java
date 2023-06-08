package net.local.dddpoc.catalog.infrastructure.entities;

import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.product.entities.Description;
import net.local.dddpoc.catalog.application.domain.product.entities.Product;
import net.local.dddpoc.catalog.application.domain.product.entities.ProductId;
import net.local.dddpoc.catalog.application.domain.product.entities.Title;

public record ProductJdbc(ProductId id, Title title, Description description, Money price) implements Product {}
