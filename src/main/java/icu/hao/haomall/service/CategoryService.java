package icu.hao.haomall.service;

import icu.hao.haomall.model.pojo.Category;
import icu.hao.haomall.requests.AddCategoryResquest;

public interface CategoryService {
    void add(AddCategoryResquest addCategoryReq);

    void update(Category updateCategoryRequest);

    void delete(Integer id);
}
