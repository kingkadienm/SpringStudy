package com.example.demo.repository;

import com.example.demo.bean.WarehouseBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: wangzs
 * @create: 2023/6/16 18:08
 **/
public interface WarehouseRepository extends JpaRepository<WarehouseBean,Long> {

}
