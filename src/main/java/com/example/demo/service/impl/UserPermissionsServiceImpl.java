package com.example.demo.service.impl;

import com.example.demo.common.util.ArrayUtils;
import com.example.demo.common.util.NumberUtils;
import com.example.demo.dao.MenuPermissionsDAO;
import com.example.demo.dao.UserPermissionsDAO;
import com.example.demo.model.MenuPermissions;
import com.example.demo.model.UserPermissions;
import com.example.demo.model.vo.UserPermissionsVo;
import com.example.demo.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        Set<Long> menuIds = new HashSet<>();
        for (UserPermissions permissions : userPermissions) {
            menuIds.add(permissions.getMenuId());
        }
        List<MenuPermissions> menuPermissions = menuPermissionsDAO.selectByIds(menuIds);
        Map<Long, UserPermissionsVo> menuMaps = new HashMap<>();
        for (MenuPermissions menu : menuPermissions) {
            UserPermissionsVo vo = menuMaps.get(menu.getId());
            if (null == vo) {
                vo = new UserPermissionsVo();
            }
            //如果是1级菜单
            if (NumberUtils.zero.equals(menu.getLevel())) {
                vo.setMenuName(menu.getMenuName());
                vo.setLevel(NumberUtils.zero);
                vo.setMenuUrl(menu.getMenuUrl());
                vo.setPermissionsNo(menu.getPermissionsNo());
                vo.setMenuId(menu.getId());
                menuMaps.put(menu.getId(), vo);
                continue;
            }
            //如果是2级菜单
            if (NumberUtils.one.equals(menu.getLevel())) {
                List<UserPermissionsVo> childs = vo.getChilds();
                if (ArrayUtils.listIsEmpty(childs)) {
                    childs = new ArrayList<>();
                }
                UserPermissionsVo child = new UserPermissionsVo();
                child.setMenuName(menu.getMenuName());
                child.setLevel(NumberUtils.zero);
                child.setMenuUrl(menu.getMenuUrl());
                child.setPermissionsNo(menu.getPermissionsNo());
                child.setMenuId(menu.getId());
                child.setParentId(menu.getParentId());
                childs.add(child);
                vo.setChilds(childs);
                menuMaps.put(menu.getParentId(), vo);
            }
            //不考虑3级菜单按钮
        }
        List<UserPermissionsVo> userPermissionsVos = new ArrayList<>();
        for (Map.Entry<Long, UserPermissionsVo> entry : menuMaps.entrySet()) {
            userPermissionsVos.add(entry.getValue());
        }
        return userPermissionsVos;
    }

    @Override
    public List<UserPermissions> selectByUserId(Long UserId) {
        UserPermissions condition = new UserPermissions();
        condition.setUserId(UserId);
        return userPermissionsDAO.selectByCondition(condition);
    }
}
