package com.soukue.pojo.greenyep.reqest;

import cn.hutool.crypto.SecureUtil;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 绿点支付  https://www.greenyep.com/doc/dev_transaction_create
 * @author soukue
 * 2021/3/6
 */
@Data
public class CreateOrderReq implements Serializable {
    private static final long serialVersionUID = -1425976190786105888L;

    private String uid;
    //价格 单位：元。精确小数点后2位。
    private BigDecimal amount;
    //支付宝：1; 微信：2
    private Integer type;
    //账号名称
    private String account;
    //商户自定义订单号
    private String order_id;
    //商户自定义用户编号
    private String customer_id;
    //商户自定义商品名称
    private String product_name;
    //通知回调网址
    private String notify_url;
    //同步跳转网址
    private String redirect_url;
    //签名串
    private String signature;
}
