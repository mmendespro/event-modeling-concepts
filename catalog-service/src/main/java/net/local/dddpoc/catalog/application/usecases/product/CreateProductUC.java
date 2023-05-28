package net.local.dddpoc.catalog.application.usecases.product;

import java.util.UUID;

import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.product.entities.Description;
import net.local.dddpoc.catalog.application.domain.product.entities.Product;
import net.local.dddpoc.catalog.application.domain.product.entities.ProductId;
import net.local.dddpoc.catalog.application.domain.product.entities.Title;
import net.local.dddpoc.catalog.application.domain.product.repositories.SaveProductPort;

public class CreateProductUC {
    
    private final SaveProductPort saveProductPort;

    public CreateProductUC(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    public void execute(String title, String description, float price) {
        var newProduct = new InputProduct(new ProductId(UUID.randomUUID()), new Title(title), new Description(description), new Money(price));
        saveProductPort.save(newProduct);
    }

    public record InputProduct(ProductId id, Title title, Description description, Money price) implements Product {}
}
