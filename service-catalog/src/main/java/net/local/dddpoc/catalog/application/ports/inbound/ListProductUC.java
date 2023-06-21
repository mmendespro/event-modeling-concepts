package net.local.dddpoc.catalog.application.ports.inbound;

import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.ports.outbound.LoadProductPort;

public class ListProductUC {
    
    private final LoadProductPort loadProductPort;

    public ListProductUC(LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    public Stream<Product> execute() {
        return loadProductPort.findAll();
    }
}
