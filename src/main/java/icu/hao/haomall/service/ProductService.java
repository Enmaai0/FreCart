package icu.hao.haomall.service;

import com.github.pagehelper.PageInfo;
import icu.hao.haomall.model.pojo.Product;
import icu.hao.haomall.requests.AddProductRequest;

import java.util.List;

public interface ProductService {
    void add(AddProductRequest addProductRequest);

    void update(Product product);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo<Product> listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);
}
