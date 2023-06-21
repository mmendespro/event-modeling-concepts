package net.local.dddpoc.catalog.application.domain.primitives;

public class Title {
    
    private final String title;

    public Title(String title) {
        var titleVal = (title != null) ? title.strip() : "".strip();
        if (titleVal.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty!");
        }
        this.title = titleVal;
    }

    public String value() {
        return title;
    }

}
