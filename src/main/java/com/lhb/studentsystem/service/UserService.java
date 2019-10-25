package com.lhb.studentsystem.service;

import com.lhb.studentsystem.dto.SchoolResultDTO;
import com.lhb.studentsystem.dto.UpdatePassDTO;
import com.lhb.studentsystem.mapper.UserMapper;
import com.lhb.studentsystem.model.User;
import com.lhb.studentsystem.provider.SchoolProvider;
import com.lhb.studentsystem.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseResult loginUser(User user) throws Exception {
        User user1 = userMapper.findById(user.getId());
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                user1.setPassword(null);
                user1.setSysPassword(null);
                return ResponseResult.Success(200, "登陆成功", user1);
            } else {
                return ResponseResult.Error(500, "密码错误", null);
            }
        } else {
            SchoolProvider schoolProvider = new SchoolProvider();
            SchoolResultDTO schoolResultDTO = schoolProvider.getStatus(user.getSysPassword());
            if (schoolResultDTO.isFlag()) {
                String username = schoolResultDTO.getUsername();
                user.setUsername(username);
                userMapper.addUser(user);
                user.setPassword(null);
                user.setSysPassword(null);
                return ResponseResult.Success(200, "登陆成功", user);
            } else {
                return ResponseResult.Error(500, "用户名或密码错误", null);
            }
        }
    }

    public User getUser(String id) {
        User user = userMapper.findById(id);
        return user;
    }

    public ResponseResult updatePassWord(UpdatePassDTO updatePassDTO) {
        User user = userMapper.findByUpdatePassDTO(updatePassDTO);
        if (user != null){
            userMapper.updatePassword(updatePassDTO);
            User user1 = userMapper.findById(updatePassDTO.getId());
            return ResponseResult.Success(200,"修改成功",user1);
        }
        return ResponseResult.Error(500,"原密码错误",null);
    }
}
