package com.example.demo.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @description:
 * @author: wangzs
 * @create: 2023/6/16 18:15
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class WarehouseRequestBean {
    private String userName;

    private String goodsID;

    private String devicesID;

    private String location;


}
