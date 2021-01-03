package com.itheima.ssm.domain;

import com.heima.ssm.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author panghl
 * @Date 2020/10/23 23:44
 * @Description 产品信息
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;
}
