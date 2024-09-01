package icu.hao.haomall.controller;

import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.common.Constant;
import icu.hao.haomall.model.pojo.Product;
import icu.hao.haomall.requests.AddProductRequest;
import icu.hao.haomall.requests.UpdateCategoryRequest;
import icu.hao.haomall.requests.UpdateProductRequest;
import icu.hao.haomall.service.ProductService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Controller
public class ProductAdminController {
    @Autowired
    ProductService productService;
    @PostMapping("/admin/product/add")
    public ApiRestResponse addProduct(@RequestBody @Valid AddProductRequest addProductRequest) {
        productService.add(addProductRequest);
        return ApiRestResponse.sucess();
    }
    @PostMapping("/admin/upload/file")
    public ApiRestResponse upload(HttpServletRequest httpServletRequest, @RequestParam MultipartFile file) throws URISyntaxException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + suffix;
        File fileDirectory = new File(Constant.uploadFileDir);
        File destFile = new File(Constant.uploadFileDir + newFileName);
        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdir()) {
                return ApiRestResponse.error(10013, "Failed to create directory");
            }
        }
        try {
            file.transferTo(destFile);
        } catch (Exception e) {
            return ApiRestResponse.error(10014, "Failed to upload file");
        }
        return ApiRestResponse.sucess(getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/images/" + newFileName);
    }

    private URI getHost(URI uri) {
        URI effectiveURI;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Exception e) {
            effectiveURI = null;
        }
        return effectiveURI;
    }

    @PostMapping("/admin/product/update")
    public ApiRestResponse updateProduct(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(updateProductRequest, product);
        productService.update(product);
        return ApiRestResponse.sucess();
    }

    @PostMapping("/admin/product/delete")
    public ApiRestResponse deleteProduct(@RequestParam Integer id) {
        productService.delete(id);
        return ApiRestResponse.sucess();
    }

    @PostMapping("/admin/product/batchUpdateSellStatus")
    public ApiRestResponse batchUpdateSellStatus(@RequestParam Integer[] ids, @RequestParam Integer sellStatus) {
        productService.batchUpdateSellStatus(ids, sellStatus);
        return ApiRestResponse.sucess();
    }

}
