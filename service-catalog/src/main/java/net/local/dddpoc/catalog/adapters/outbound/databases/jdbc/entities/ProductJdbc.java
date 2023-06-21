package net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.entities;

import net.local.dddpoc.catalog.application.domain.primitives.Description;
import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.domain.product.ProductId;

public record ProductJdbc(ProductId id, Title title, Description description, Money price) implements Product {}
