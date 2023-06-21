package net.local.dddpoc.catalog.application.domain.category;

import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.primitives.Uri;

public interface Category {
    
    CategoryId id();

    Uri uri();

    Title title();
}
