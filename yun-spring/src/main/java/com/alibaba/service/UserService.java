package com.alibaba.service;

import com.alibaba.bean.Result;
import com.alibaba.bean.User;
import com.alibaba.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");

            }else{
                userMapper.regist(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User info = userMapper.login(user);
            if(info == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(info);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 增加手机号
     * @param user 
     * @return Result
     */
    public Result changenum(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            userMapper.changenum(user);
            result.setMsg("验证成功");
            result.setSuccess(true);
            result.setDetail(user);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
