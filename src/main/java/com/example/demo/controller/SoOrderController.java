package com.example.demo.controller;

import com.example.demo.model.SoHeader;
import com.example.demo.service.SoHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("soOrder")
public class SoOrderController {

    @Autowired
    private SoHeaderService soHeaderService;

    public List<SoHeader> selectByCondition(SoHeader soHeader) {
        return soHeaderService.selectByCondition(soHeader);
    }
}
