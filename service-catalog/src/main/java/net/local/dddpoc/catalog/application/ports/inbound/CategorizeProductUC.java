package net.local.dddpoc.catalog.application.ports.inbound;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.product.ProductId;
import net.local.dddpoc.catalog.application.ports.outbound.LoadProductPort;
import net.local.dddpoc.catalog.application.ports.outbound.SaveProductPort;

public class CategorizeProductUC {
    
    private final LoadProductPort loadProductPort;
    private final SaveProductPort saveProductPort;

    public CategorizeProductUC(LoadProductPort loadProductPort, SaveProductPort saveProductPort) {
        this.loadProductPort = loadProductPort;
        this.saveProductPort = saveProductPort;
    }

    public void execute(CategoryId categoryId, ProductId productId) {
        loadProductPort.findById(productId).ifPresentOrElse(
            (prod) -> {
                saveProductPort.categorize(categoryId.value(), productId.value());
            },
            () -> {
                throw new IllegalArgumentException("Product does not exist.");
            }
        );
    }
}
