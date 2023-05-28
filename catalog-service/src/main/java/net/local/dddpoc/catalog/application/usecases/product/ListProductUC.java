package net.local.dddpoc.catalog.application.usecases.product;

import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.product.entities.Product;
import net.local.dddpoc.catalog.application.domain.product.repositories.LoadProductPort;

public class ListProductUC {
    
    private final LoadProductPort loadProductPort;

    public ListProductUC(LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    public Stream<Product> execute() {
        return loadProductPort.findAll();
    }
}
