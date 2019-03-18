package com.example.demo.common.baseclass;

import java.util.List;

public interface BaseService<T extends BaseModel> {
    T insert(T var);

    T update(T var);

    List<T> selectByCondition(T condition);
}
