package icu.hao.haomall.service.impl;

import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.dao.ProductMapper;
import icu.hao.haomall.model.pojo.Product;
import icu.hao.haomall.requests.AddProductRequest;
import icu.hao.haomall.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void add(AddProductRequest addProductRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(addProductRequest, product);
        Product productOld = productMapper.selectByName(product.getName());
        if (productOld != null) {
            throw new Exception(ExceptionEnum.NAME_EXISTED);
        }
        int count = productMapper.insertSelective(product);
        if (count == 0) {
            throw new Exception(ExceptionEnum.INSERT_FAILED);
        }
    }
}
