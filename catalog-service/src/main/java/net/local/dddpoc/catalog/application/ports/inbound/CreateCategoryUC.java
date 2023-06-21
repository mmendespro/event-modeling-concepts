package net.local.dddpoc.catalog.application.ports.inbound;

import java.util.UUID;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.primitives.Uri;
import net.local.dddpoc.catalog.application.ports.outbound.SaveCategoryPort;
import net.local.dddpoc.catalog.application.valueObjects.InputCategory;

public class CreateCategoryUC {
    
    private final SaveCategoryPort saveCategoryPort;

    public CreateCategoryUC(SaveCategoryPort saveCategoryPort) {
        this.saveCategoryPort = saveCategoryPort;
    }

    public void execute(String title, String uri) {
        var newCategory = new InputCategory(new CategoryId(UUID.randomUUID()), new Uri(uri), new Title(title));

        saveCategoryPort.save(newCategory);
    }
}
