package icu.hao.haomall.controller;

import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.common.Constant;
import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.pojo.User;
import icu.hao.haomall.requests.AddCategoryResquest;
import icu.hao.haomall.service.CategoryService;
import icu.hao.haomall.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session, AddCategoryResquest addCategoryReq) {
        if (addCategoryReq.getName() == null ||
                addCategoryReq.getType() == null ||
                addCategoryReq.getParentId() == null ||
                addCategoryReq.getOrderNum() == null) {
            return ApiRestResponse.error(ExceptionEnum.PARA_NOT_NULL);
        }
        User curUser = (User) session.getAttribute(Constant.HAOMALL_USER);
        if (curUser == null) return ApiRestResponse.error(ExceptionEnum.NEED_LOGIN);
        boolean isAdmin = userService.isAdmin(curUser);
        if (isAdmin) {
            categoryService.add(addCategoryReq);
        } else {
            ApiRestResponse.error(ExceptionEnum.NEED_ADMIN);
        }
        return ApiRestResponse.sucess();
    }
}
