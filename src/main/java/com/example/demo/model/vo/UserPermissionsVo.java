package com.example.demo.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPermissionsVo {
    private Long parentId;
    private Integer level;
    private String permissionsNo;
    private String menuName;
    private String menuUrl;
    private Long userId;
    private Long menuId;
    private List<UserPermissionsVo> childs;
}
