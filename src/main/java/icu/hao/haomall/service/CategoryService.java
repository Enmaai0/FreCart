package icu.hao.haomall.service;

import com.github.pagehelper.PageInfo;
import icu.hao.haomall.model.VO.CategoryVO;
import icu.hao.haomall.model.pojo.Category;
import icu.hao.haomall.requests.AddCategoryResquest;

import java.util.List;

public interface CategoryService {
    void add(AddCategoryResquest addCategoryReq);

    void update(Category updateCategoryRequest);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer parentId);
}
