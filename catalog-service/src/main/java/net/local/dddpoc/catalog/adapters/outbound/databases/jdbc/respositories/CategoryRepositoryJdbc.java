package net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.respositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.entities.CategoryJdbc;
import net.local.dddpoc.catalog.application.domain.category.Category;
import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.primitives.Uri;
import net.local.dddpoc.catalog.application.ports.outbound.LoadCategoryPort;
import net.local.dddpoc.catalog.application.ports.outbound.SaveCategoryPort;

@Repository
public class CategoryRepositoryJdbc implements LoadCategoryPort, SaveCategoryPort {
    
    private final JdbcTemplate jdbcTemplate;

    private final String QRY_LOAD_ALL = "select * from categories ";
    private final String QRY_LOAD_BYID = "select * from categories where categoryId = ?";
    private final String QRY_INSERT = "insert into categories (categoryId, title, uri) values (?, ?, ?)";
    private final String QRY_UPDATE = "update categories set title = ?, uri = ? where categoryId = ?";

    public CategoryRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stream<Category> loadAll() {
        return jdbcTemplate.queryForList(QRY_LOAD_ALL.concat(" ORDER BY 1")).stream().map(this::toCategory);
    }

    @Override
    public Optional<Category> loadById(CategoryId categoryId) {
        List<Map<String, Object>> entries = jdbcTemplate.queryForList(QRY_LOAD_BYID, categoryId.value());
        return entries.stream().map(this::toCategory).findFirst(); 
    }

    @Override
    public void save(Category category) {
        loadById(category.id()).ifPresentOrElse((cat) -> {
            jdbcTemplate.update(QRY_UPDATE, category.title().value(), category.uri().value(), category.id().value());
        }, () -> {
            jdbcTemplate.update(QRY_INSERT, category.id().value(), category.title().value(), category.uri().value());
        });
    } 

    private Category toCategory(Map<String, Object> entry) {
        return new CategoryJdbc(
                new CategoryId(entry.get("categoryId")),
                new Uri((String) entry.get("uri")),
                new Title((String) entry.get("title")));
    }
}
