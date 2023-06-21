package net.local.dddpoc.catalog.application.domain.category;

public class CategoryId {

    private final String id;

    public CategoryId(Object id) {
        var idVal = (id != null) ? id.toString().strip() : "".strip();
        if (idVal.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = idVal;
    }

    public String value() {
        return id;
    }
    
}
