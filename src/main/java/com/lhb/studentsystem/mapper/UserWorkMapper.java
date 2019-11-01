package com.lhb.studentsystem.mapper;

import com.lhb.studentsystem.model.UserWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserWorkMapper {
    void InsertWork(UserWork userWork);

    List<UserWork> findByUserId(@Param("userId") String userId);

    UserWork findWork(@Param("userId") String userId,
                      @Param("workId") Integer workId);

    void createFile(@Param("file") String newName, @Param("userId") String userId, @Param("workId") Integer workId, @Param("commitTime") Date date, @Param("status") String status);

    void updateFile(@Param("file") String newName, @Param("userId") String userId, @Param("workId") Integer workId, @Param("modifiedTime") Date date, @Param("status") String status);

    List<UserWork> findWorkListByWorkId(@Param("workId") Integer workId);
}
