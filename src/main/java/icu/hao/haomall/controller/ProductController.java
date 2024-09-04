package icu.hao.haomall.controller;

import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.model.pojo.Product;
import icu.hao.haomall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/product/detail")
    public ApiRestResponse detail(Integer id) {
        Product product = productService.detail(id);
        return ApiRestResponse.sucess(product);
    }
}
