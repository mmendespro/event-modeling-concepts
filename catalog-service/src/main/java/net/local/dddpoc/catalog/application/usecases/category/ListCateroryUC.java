package net.local.dddpoc.catalog.application.usecases.category;

import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;
import net.local.dddpoc.catalog.application.domain.category.repositories.LoadCategoryPort;

public class ListCateroryUC {
    
    private final LoadCategoryPort loadCategoryPort;

    public ListCateroryUC(LoadCategoryPort loadCategoryPort) {
        this.loadCategoryPort = loadCategoryPort;
    }

    public Stream<Category> execute() {
        return loadCategoryPort.loadAll();
    }
}
