package icu.hao.haomall.service;

import icu.hao.haomall.model.pojo.Product;
import icu.hao.haomall.requests.AddProductRequest;

public interface ProductService {
    public void add(AddProductRequest addProductRequest);

    void update(Product product);

    void delete(Integer id);
}
