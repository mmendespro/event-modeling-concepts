package net.local.dddpoc.catalog.application.domain.primitives;

import java.util.regex.Pattern;

public class Uri {
    
    private static final String PATTERN = "[a-z]([a-z0-9-]*[a-z0-9])?";

    private final String uri;

    public Uri(String uri) {
        var uriVal = (uri != null) ? uri.strip() : "".strip();
        if (uriVal.isBlank()) {
            throw new IllegalArgumentException("URI cannot be empty!");
        }
        if (!Pattern.matches(PATTERN, uriVal)) {
            throw new IllegalArgumentException("URI value is invalid!");
        }
        this.uri = uriVal;
    }

    public String value() {
        return uri;
    }
}
