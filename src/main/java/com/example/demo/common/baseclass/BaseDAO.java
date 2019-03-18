package com.example.demo.common.baseclass;

import java.util.Collection;
import java.util.List;

public interface BaseDAO <T extends BaseModel>{
    List<T> selectByCondition(T var1);

    int removeByIds(Collection<Long> var1);

    int insert(T var1);

    int update(T var1);

    List<T> selectByIds(Collection<Long> var1);
}
