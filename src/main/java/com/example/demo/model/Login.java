package com.example.demo.model;



import com.example.demo.common.baseclass.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Login extends BaseModel {
    private String loginName;
    private String password;
    private String userName;
    private Date createTime;
    private Date updateTime;
}
