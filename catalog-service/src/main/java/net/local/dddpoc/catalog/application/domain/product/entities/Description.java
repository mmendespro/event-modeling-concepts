package net.local.dddpoc.catalog.application.domain.product.entities;

public final class Description {

    private final String description;

    public Description(String description) {
        this.description = description != null ? description.strip() : "";
    }

    public String value() {
        return description;
    }
}
