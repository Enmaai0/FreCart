package icu.hao.haomall.controller;

import icu.hao.haomall.common.ApiRestResponse;
import icu.hao.haomall.common.Constant;
import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.pojo.User;
import icu.hao.haomall.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test/{id}")
    @ResponseBody
    public User personalPage(@PathVariable("id") int id) {
        return userService.getUser();
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse<Object> register(@RequestParam("userName") String userName, @RequestParam("password") String password) throws Exception, NoSuchAlgorithmException {
        if (userName == null || userName.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (password == null || password.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }
        if (password.length() < 8) {
            return ApiRestResponse.error(ExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(userName, password);
        return ApiRestResponse.sucess();
    }

    @PostMapping("login")
    @ResponseBody
    public ApiRestResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession httpSession) throws Exception {
        if (userName == null || userName.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (password == null || password.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }

        User user = userService.login(userName, password);
        user.setPassword(null);
        httpSession.setAttribute(Constant.HAOMALL_USER, user);
        return ApiRestResponse.sucess(user);
    }

    @PostMapping("user/update")
    @ResponseBody
    public ApiRestResponse updateUserInfo(@RequestParam String signature, HttpSession session) throws Exception {
        User currentUser = (User) session.getAttribute(Constant.HAOMALL_USER);
        if (currentUser == null) {
            throw new Exception(ExceptionEnum.NEED_LOGIN);
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateInfomation(user);
        return ApiRestResponse.sucess();
    }

    @PostMapping("/logout")
    @ResponseBody
    public ApiRestResponse logout(HttpSession session) {
        session.removeAttribute(Constant.HAOMALL_USER);
        return ApiRestResponse.sucess();
    }

    @PostMapping("/adminLogin")
    @ResponseBody
    public ApiRestResponse adminLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession httpSession) throws Exception {
        if (userName == null || userName.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (password == null || password.isEmpty()) {
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(userName, password);
        if (userService.isAdmin(user)) {
            user.setPassword(null);
            httpSession.setAttribute(Constant.HAOMALL_USER, user);
            return ApiRestResponse.sucess(user);
        } else {
            return ApiRestResponse.error(ExceptionEnum.NEED_ADMIN);
        }
    }

}
