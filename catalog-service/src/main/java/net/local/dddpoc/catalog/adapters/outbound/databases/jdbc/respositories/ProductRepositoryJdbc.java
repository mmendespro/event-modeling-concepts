package net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.respositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.entities.ProductJdbc;
import net.local.dddpoc.catalog.application.domain.primitives.Description;
import net.local.dddpoc.catalog.application.domain.primitives.Money;
import net.local.dddpoc.catalog.application.domain.primitives.Title;
import net.local.dddpoc.catalog.application.domain.product.Product;
import net.local.dddpoc.catalog.application.domain.product.ProductId;
import net.local.dddpoc.catalog.application.ports.outbound.LoadProductPort;
import net.local.dddpoc.catalog.application.ports.outbound.SaveProductPort;

@Repository
public class ProductRepositoryJdbc implements LoadProductPort, SaveProductPort {
    
    private final String QRY_LOAD_ALL = "select * from products ";
    private final String QRY_LOAD_BYID = "select * from products where productId = ?";
    private final String QRY_INSERT = "INSERT INTO products VALUES (?, ?, ?, ?)";
    private final String QRY_UPDATE = "UPDATE products SET title = ?, description, price = ? where productId = ?";
    private final String QRY_CATEGORIZE = "INSERT INTO products_in_categories VALUES(?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stream<Product> findAll() {
        return jdbcTemplate.queryForList(QRY_LOAD_ALL.concat(" ORDER BY 1")).stream().map(this::toProduct);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        List<Map<String, Object>> entries = jdbcTemplate.queryForList(QRY_LOAD_BYID, productId.value());
        return entries.stream().map(this::toProduct).findFirst(); 
    }

    @Override
    public void categorize(String categoryId, String productId) {
        jdbcTemplate.update(QRY_CATEGORIZE, categoryId, productId);
    }

    @Override
    public void save(Product product) {
        findById(product.id()).ifPresentOrElse((prod) -> {
            jdbcTemplate.update(QRY_UPDATE, product.title().value(), product.description().value(), product.price().value(), product.id().value());
        }, () -> {
            jdbcTemplate.update(QRY_INSERT, product.id().value(), product.title().value(), product.description().value(), product.price().value());
        });
    }

    private Product toProduct(Map<String, Object> entry) {
        return new ProductJdbc(
                new ProductId(entry.get("productId")),
                new Title((String) entry.get("title")),
                new Description((String) entry.get("description")),
                new Money(((BigDecimal) entry.get("price")).floatValue()));
    }
}
