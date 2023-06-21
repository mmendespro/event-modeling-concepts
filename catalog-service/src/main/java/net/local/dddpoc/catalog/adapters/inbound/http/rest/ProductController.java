package net.local.dddpoc.catalog.adapters.inbound.http.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.dddpoc.catalog.application.domain.category.CategoryId;
import net.local.dddpoc.catalog.application.domain.product.ProductId;
import net.local.dddpoc.catalog.application.ports.inbound.CategorizeProductUC;
import net.local.dddpoc.catalog.application.ports.inbound.CreateProductUC;
import net.local.dddpoc.catalog.application.ports.inbound.ListProductUC;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private final ListProductUC listProductUC;
    private final CreateProductUC createProductUC;
    private final CategorizeProductUC categorizeProductUC;

    public ProductController(ListProductUC listProductUC, CreateProductUC createProductUC, CategorizeProductUC categorizeProductUC) {
        this.listProductUC = listProductUC;
        this.createProductUC = createProductUC;
        this.categorizeProductUC = categorizeProductUC;
    }

    @GetMapping
    public List<Map<String, ?>> listProduct() {
        return listProductUC.execute().map(product -> Map.of("id", product.id().value(),
                                                            "title", product.title().value(),
                                                            "description", product.description().value(), 
                                                            "price", product.price().value())).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Map<String, ?> data) {
        createProductUC.execute(data.get("title").toString(), data.get("description").toString(), Float.parseFloat(data.get("price").toString()));
        return ResponseEntity.ok().build();
    }

    @PutMapping("{productId}/categorize/{categoryId}")
    public ResponseEntity<String> categorizeProduct(@PathVariable String productId, @PathVariable String categoryId) {
        categorizeProductUC.execute(new CategoryId(categoryId), new ProductId(productId));
        return ResponseEntity.ok().build();
    }
}
