package ru.dzolotarev.springbootapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dzolotarev.springbootapi.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<String> getProducts() {
        return productService.getProducts();
    }


}
