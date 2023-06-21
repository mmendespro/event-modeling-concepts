package net.local.dddpoc.catalog.application.ports.inbound;

import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.ports.outbound.LoadProductPort;

public class ProductByCategoryUC {
    
    private final LoadProductPort loadProductPort;

    public ProductByCategoryUC(LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    public Stream<Product> execute(CategoryId categoryId) {
        return loadProductPort.findByCategory(categoryId);
    }

}
