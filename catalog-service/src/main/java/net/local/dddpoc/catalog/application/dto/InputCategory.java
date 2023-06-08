package net.local.dddpoc.catalog.application.dto;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;
import net.local.dddpoc.catalog.application.domain.category.entities.CategoryId;
import net.local.dddpoc.catalog.application.domain.category.entities.Title;
import net.local.dddpoc.catalog.application.domain.category.entities.Uri;

public record InputCategory(CategoryId id, Uri uri, Title title) implements Category{} 
