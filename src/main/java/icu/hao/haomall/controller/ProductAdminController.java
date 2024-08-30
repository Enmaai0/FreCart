package icu.hao.haomall.controller;

import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.requests.AddProductRequest;
import icu.hao.haomall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductAdminController {
    @Autowired
    ProductService productService;
    @PostMapping("/admin/product/add")
    public ApiRestResponse addProduct(@RequestBody @Valid AddProductRequest addProductRequest) {
        productService.add(addProductRequest);
        return ApiRestResponse.sucess();
    }
}
