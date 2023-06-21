package net.local.dddpoc.catalog.adapters.inbound.http.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.ports.inbound.CreateCategoryUC;
import net.local.dddpoc.catalog.application.ports.inbound.ListCateroryUC;
import net.local.dddpoc.catalog.application.ports.inbound.ProductByCategoryUC;
import net.local.dddpoc.catalog.application.valueObjects.InputCategory;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final ListCateroryUC listCateroryUC;
    private final CreateCategoryUC createCategoryUC;
    private final ProductByCategoryUC productByCategoryUC;

    public CategoryController(ListCateroryUC listCateroryUC, CreateCategoryUC createCategoryUC, ProductByCategoryUC productByCategoryUC) {
        this.listCateroryUC = listCateroryUC;
        this.createCategoryUC = createCategoryUC;
        this.productByCategoryUC = productByCategoryUC;
    }
    
    @GetMapping
    public List<Map<String, ?>> listCategories() {
        return listCateroryUC.execute()
                             .map(category -> Map.of("id", category.id().value(),"title", category.title().value(),"uri", category.uri().value()))
                             .collect(Collectors.toList());
    }

    @GetMapping("{categoryId}/products")
    public List<Map<String, ?>> listByCategories(@PathVariable String categoryId) {
        return productByCategoryUC.execute(new CategoryId(categoryId))
                                  .map(prod -> Map.of("id", prod.id().value(),"title", prod.title().value(), "price", prod.price().value()))
                                  .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody InputCategory inputCategory) {
        createCategoryUC.execute(inputCategory.title().value(), inputCategory.uri().value());
        return ResponseEntity.ok().build();
    }
}
