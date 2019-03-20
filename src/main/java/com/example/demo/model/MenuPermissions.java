package com.example.demo.model;

import com.example.demo.common.baseclass.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPermissions extends BaseModel {
    private Long parentId;
    private Integer level;
    private String permissionsNo;
    private String menuName;
    private String menuUrl;
}
