package net.local.dddpoc.catalog.application.domain.product;

public class ProductId {
    
    private final String id;

    public ProductId(Object id) {
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
