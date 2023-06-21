package net.local.dddpoc.catalog.application.ports.inbound;

import java.util.UUID;

import net.local.dddpoc.catalog.application.domain.primitives.Description;
import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.product.ProductId;
import net.local.dddpoc.catalog.application.ports.outbound.SaveProductPort;
import net.local.dddpoc.catalog.application.valueObjects.InputProduct;

public class CreateProductUC {
    
    private final SaveProductPort saveProductPort;

    public CreateProductUC(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    public void execute(String title, String description, float price) {
        var newProduct = new InputProduct(new ProductId(UUID.randomUUID()), new Title(title), new Description(description), new Money(price));
        saveProductPort.save(newProduct);
    }
}
