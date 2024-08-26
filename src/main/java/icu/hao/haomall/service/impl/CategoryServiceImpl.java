package icu.hao.haomall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.VO.CategoryVO;
import icu.hao.haomall.model.dao.CategoryMapper;
import icu.hao.haomall.model.pojo.Category;
import icu.hao.haomall.requests.AddCategoryResquest;
import icu.hao.haomall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void delete(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null) throw new Exception(ExceptionEnum.DELETE_FAILED);
        int count = categoryMapper.deleteByPrimaryKey(id);
        if (count == 0) throw new Exception(ExceptionEnum.DELETE_FAILED);
    }

    @Override
    public PageInfo listForAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, "type,order_num");
        List<Category> categoryList = categoryMapper.selectList();
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }

    @Override
    @Cacheable(value = "listCategoryForCustomer")
    public List<CategoryVO> listCategoryForCustomer(Integer parentId) {
        List<Category> categories = categoryMapper.selectByParentId(parentId);
        List<CategoryVO> categoryVOList = new ArrayList<>();
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category, categoryVO);
            List<CategoryVO> subCategories = listCategoryForCustomer(category.getId());
            categoryVO.setSubCategories(subCategories);
            categoryVOList.add(categoryVO);
        }
        return categoryVOList;
    }
}
