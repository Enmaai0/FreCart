package icu.hao.haomall.service;

import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.model.pojo.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    User getUser();

    void register(String userName, String password) throws Exception, NoSuchAlgorithmException;

    User login(String userName, String password) throws Exception;

    void updateInfomation(User user);

    boolean isAdmin(User user);
}
