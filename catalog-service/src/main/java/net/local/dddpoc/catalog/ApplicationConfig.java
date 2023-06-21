package net.local.dddpoc.catalog;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.respositories.CategoryRepositoryJdbc;
import net.local.dddpoc.catalog.adapters.outbound.databases.jdbc.respositories.ProductRepositoryJdbc;
import net.local.dddpoc.catalog.application.ports.inbound.CategorizeProductUC;
import net.local.dddpoc.catalog.application.ports.inbound.CreateCategoryUC;
import net.local.dddpoc.catalog.application.ports.inbound.CreateProductUC;
import net.local.dddpoc.catalog.application.ports.inbound.ListCateroryUC;
import net.local.dddpoc.catalog.application.ports.inbound.ListProductUC;

@Configuration
public class ApplicationConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                                            .addScripts("/schema.sql", "/example-data.sql")
                                            .build();
    }


    @Bean
    public ListCateroryUC listCateroryUC(CategoryRepositoryJdbc repository) {
        return new ListCateroryUC(repository);
    }

    @Bean
    public CreateCategoryUC createCategoryUC(CategoryRepositoryJdbc repository) {
        return new CreateCategoryUC(repository);
    }

    @Bean
    public ListProductUC listProductUC(ProductRepositoryJdbc repository) {
        return new ListProductUC(repository);
    }

    @Bean
    public CreateProductUC createProductUC(ProductRepositoryJdbc repository) {
        return new CreateProductUC(repository);
    }

    @Bean
    public CategorizeProductUC categorizeProductUC(ProductRepositoryJdbc repository) {
        return new CategorizeProductUC(repository, repository);
    }
}