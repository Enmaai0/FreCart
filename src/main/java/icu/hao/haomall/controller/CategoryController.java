package icu.hao.haomall.controller;

import com.github.pagehelper.PageInfo;
import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.common.Constant;
import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.VO.CategoryVO;
import icu.hao.haomall.model.pojo.Category;
import icu.hao.haomall.model.pojo.User;
import icu.hao.haomall.requests.AddCategoryResquest;
import icu.hao.haomall.requests.UpdateCategoryRequest;
import icu.hao.haomall.service.CategoryService;
import icu.hao.haomall.service.ProductService;
import icu.hao.haomall.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(@Valid @RequestBody AddCategoryResquest addCategoryReq) {
        categoryService.add(addCategoryReq);
        return ApiRestResponse.sucess();
    }

    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(updateCategoryRequest, category);
        categoryService.update(category);
        return ApiRestResponse.sucess();
    }

    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.sucess();
    }

    @GetMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.sucess(pageInfo);
    }

    @GetMapping("category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.sucess(categoryVOS);
    }

}
