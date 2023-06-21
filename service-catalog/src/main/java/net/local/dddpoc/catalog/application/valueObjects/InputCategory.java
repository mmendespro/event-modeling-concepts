package net.local.dddpoc.catalog.application.valueObjects;

import net.local.dddpoc.catalog.application.domain.category.Category;
import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.primitives.Uri;

public record InputCategory(CategoryId id, Uri uri, Title title) implements Category{} 
