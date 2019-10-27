package com.lhb.studentsystem.mapper;

import com.lhb.studentsystem.dto.UpdatePassDTO;
import com.lhb.studentsystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByName(@Param("username") String username);

    void addUser(User user);

    User findById(@Param("id") String id);

    User findByUpdatePassDTO(UpdatePassDTO updatePassDTO);

    void updatePassword(UpdatePassDTO updatePassDTO);

    List<User> findAllUser();

}
