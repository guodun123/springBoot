package com.example.demo.common.baseclass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 4298005033602998271L;
    private List<Long> ids;
    private Long id;
}
