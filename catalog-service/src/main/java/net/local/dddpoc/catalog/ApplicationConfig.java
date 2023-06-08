package net.local.dddpoc.catalog;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import net.local.dddpoc.catalog.application.usecases.category.CreateCategoryUC;
import net.local.dddpoc.catalog.application.usecases.category.ListCateroryUC;
import net.local.dddpoc.catalog.application.usecases.product.CategorizeProductUC;
import net.local.dddpoc.catalog.application.usecases.product.CreateProductUC;
import net.local.dddpoc.catalog.application.usecases.product.ListProductUC;
import net.local.dddpoc.catalog.infrastructure.repositories.CategoryRepositoryJdbc;
import net.local.dddpoc.catalog.infrastructure.repositories.ProductRepositoryJdbc;

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