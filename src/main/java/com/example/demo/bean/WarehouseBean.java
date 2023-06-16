package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: wangzs
 * @create: 2023/6/16 16:56
 **/

@Entity
@Table(name = "warehouse")
@Data
public class WarehouseBean implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "goods_id")
    private String goodsID;

    @Column(name = "devices_id")
    private String devicesID;

    @Column(name = "location")
    private String location;

    @Column(name = "save_date")
    private Date saveDate;

    @Column(name = "take_date")
    private Date takeDate;
}
