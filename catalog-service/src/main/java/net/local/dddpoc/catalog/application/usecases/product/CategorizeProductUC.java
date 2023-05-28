package net.local.dddpoc.catalog.application.usecases.product;

import net.local.dddpoc.catalog.application.domain.category.entities.CategoryId;
import net.local.dddpoc.catalog.application.domain.product.entities.ProductId;
import net.local.dddpoc.catalog.application.domain.product.repositories.LoadProductPort;
import net.local.dddpoc.catalog.application.domain.product.repositories.SaveProductPort;

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
