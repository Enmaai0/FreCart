package icu.hao.haomall.service.impl;

import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.dao.CategoryMapper;
import icu.hao.haomall.model.pojo.Category;
import icu.hao.haomall.requests.AddCategoryResquest;
import icu.hao.haomall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public void add(AddCategoryResquest addCategoryReq) {
        Category category = new Category();
        BeanUtils.copyProperties(addCategoryReq, category);
        Category categoryOld = categoryMapper.selectByName(category.getName());
        if (categoryOld != null) {
            throw new Exception(ExceptionEnum.NAME_EXISTED);
        }
        int count = categoryMapper.insertSelective(category);
        if (count == 0) {
            throw new Exception(ExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public void update(Category updateCategoryRequest) {
        if (updateCategoryRequest.getName() != null) {
            Category category_old = categoryMapper.selectByName(updateCategoryRequest.getName());
            if (category_old != null && !category_old.getId().equals(updateCategoryRequest.getId())) {
                throw new Exception(ExceptionEnum.NAME_EXISTED);
            }
        }
        int count = categoryMapper.updateByPrimaryKeySelective(updateCategoryRequest);
        if (count == 0) {
            throw new Exception(ExceptionEnum.UPDATE_FAILED);
        }
    }
}
