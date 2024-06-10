package icu.hao.haomall.service.impl;

import icu.hao.haomall.exception.Exception;
import icu.hao.haomall.exception.ExceptionEnum;
import icu.hao.haomall.model.dao.UserMapper;
import icu.hao.haomall.model.pojo.User;
import icu.hao.haomall.service.UserService;
import icu.hao.haomall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(2);
    }

    @Override
    public void register(String userName, String password) throws Exception, NoSuchAlgorithmException {
        User result = userMapper.selectByName(userName);
        if (result != null) {
            throw new Exception(ExceptionEnum.NAME_EXISTED);
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(MD5Utils.md5(password));
        int count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new Exception(ExceptionEnum.INSERT_FAILED);
        }

    }

    @Override
    public User login(String userName, String password) throws Exception {
        User user = null;
        try {
            user = userMapper.selectByLogin(userName, MD5Utils.md5(password));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if (user == null) {
            throw new Exception(ExceptionEnum.INCORRECT_PASSWORD);
        }
        return user;
    }

    @Override
    public void updateInfomation(User user) {
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 1){
            try {
                throw new Exception(ExceptionEnum.UPDATE_FAILED);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getRole().equals(2);
    }
}
