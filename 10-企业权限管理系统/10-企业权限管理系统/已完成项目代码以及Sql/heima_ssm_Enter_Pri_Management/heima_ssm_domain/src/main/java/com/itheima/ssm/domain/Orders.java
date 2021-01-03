package com.itheima.ssm.domain;

import com.heima.ssm.utils.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 16:35
 * @Description TODO
 **/
@Data
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private String orderStatusStr;
    private int orderStatus;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        if (this.getOrderTime()!=null){
            String result = DateUtils.date2String(this.getOrderTime(), "yyyy-MM-dd HH:mm");
            return result;
        }
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        if (payType!=null){
            if (payType==0){
                payTypeStr="支付宝";
            }else if (payType==1){
                payTypeStr="微信";
            }else {payTypeStr="其他";}
        }
        return payTypeStr;
    }

    public String getOrderStatusStr() {
        return this.getOrderStatus()==0 ? "未支付":"已支付" ;
    }
}
