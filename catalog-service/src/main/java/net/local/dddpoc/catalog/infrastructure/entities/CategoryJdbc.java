package net.local.dddpoc.catalog.infrastructure.entities;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;
import net.local.dddpoc.catalog.application.domain.category.entities.CategoryId;
import net.local.dddpoc.catalog.application.domain.category.entities.Title;
import net.local.dddpoc.catalog.application.domain.category.entities.Uri;

public record CategoryJdbc(CategoryId id, Uri uri, Title title) implements Category {}

