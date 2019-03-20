package com.example.demo.service;

import com.example.demo.model.UserPermissions;
import com.example.demo.model.vo.UserPermissionsVo;

import java.util.List;

public interface UserPermissionsService {
    List<UserPermissionsVo> findUserPermissionByUserId(Long  userId);
    List<UserPermissions> selectByUserId(Long UserId);
}
