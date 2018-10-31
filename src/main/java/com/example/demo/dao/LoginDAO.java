package com.example.demo.dao;

import com.example.demo.model.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Repository
public interface LoginDAO {
    List<Login> selectByContion(Login var1);

    int deleteByIds(Collection<Long> var1);

    int deleteByIds(@Param("list") Collection<Long> var1, @Param("updatedBy") long var2, @Param("updateTime") Date var4);

    int removeByIds(Collection<Long> var1);

    int insert(Login var1);

    int update(Login var1);
}
