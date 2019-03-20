package com.example.demo.model;

import com.example.demo.common.baseclass.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPermissions extends BaseModel {
    private Long userId;
    private Long menuId;
}
