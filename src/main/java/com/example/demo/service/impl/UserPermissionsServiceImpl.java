package com.example.demo.service.impl;

import com.example.demo.common.util.ArrayUtils;
import com.example.demo.dao.MenuPermissionsDAO;
import com.example.demo.dao.UserPermissionsDAO;
import com.example.demo.model.MenuPermissions;
import com.example.demo.model.UserPermissions;
import com.example.demo.model.vo.UserPermissionsVo;
import com.example.demo.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {
    @Autowired
    private UserPermissionsDAO userPermissionsDAO;
    @Autowired
    private MenuPermissionsDAO menuPermissionsDAO;

    @Override
    public List<UserPermissionsVo> findUserPermissionByUserId(Long userId) {
        List<UserPermissions> userPermissions = this.selectByUserId(userId);
        if (ArrayUtils.listIsEmpty(userPermissions)) {
            return null;
        }
        //查询菜单id
        Set<Long> menuIds= new HashSet<>();
        for(UserPermissions permissions : userPermissions){
            menuIds.add(permissions.getMenuId());
        }
        List<MenuPermissions> menuPermissions = menuPermissionsDAO.selectByIds(menuIds);
        return null;
    }

    @Override
    public List<UserPermissions> selectByUserId(Long UserId) {
        UserPermissions condition = new UserPermissions();
        condition.setUserId(UserId);
        return userPermissionsDAO.selectByCondition(condition);
    }
}
