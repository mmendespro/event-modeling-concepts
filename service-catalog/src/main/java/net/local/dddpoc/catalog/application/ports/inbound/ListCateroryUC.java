package net.local.dddpoc.catalog.application.ports.inbound;

import java.util.stream.Stream;

import net.local.dddpoc.catalog.application.domain.category.Category;
import net.local.dddpoc.catalog.application.ports.outbound.LoadCategoryPort;

public class ListCateroryUC {
    
    private final LoadCategoryPort loadCategoryPort;

    public ListCateroryUC(LoadCategoryPort loadCategoryPort) {
        this.loadCategoryPort = loadCategoryPort;
    }

    public Stream<Category> execute() {
        return loadCategoryPort.loadAll();
    }
}
