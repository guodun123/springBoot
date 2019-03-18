package com.example.demo.model;

import com.example.demo.common.baseclass.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SoHeader extends BaseModel {
    private String orderCode;
    private String receiver;
    private String address;
    private String createTime;
    private BigDecimal costAmount;
    private BigDecimal expressAmount;
    private BigDecimal receivedAmount;
    private BigDecimal expressNo;
}
