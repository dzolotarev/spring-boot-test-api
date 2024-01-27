package ru.dzolotarev.springbootapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dzolotarev.springbootapi.client.ProductClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public List<String> getProducts() {
        return productClient.getProducts();
    }

}
