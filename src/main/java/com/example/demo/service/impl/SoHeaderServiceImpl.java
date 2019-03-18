package com.example.demo.service.impl;

import com.example.demo.dao.SoHeaderDAO;
import com.example.demo.model.SoHeader;
import com.example.demo.service.SoHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoHeaderServiceImpl implements SoHeaderService {
    @Autowired
    private SoHeaderDAO soHeaderDAO;

    @Override
    public SoHeader insert(SoHeader var) {
        soHeaderDAO.insert(var);
        return var;
    }

    @Override
    public SoHeader update(SoHeader var) {
        soHeaderDAO.update(var);
        return var;
    }

    @Override
    public List<SoHeader> selectByCondition(SoHeader condition) {
        return soHeaderDAO.selectByCondition(condition);
    }
}
