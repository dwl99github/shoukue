package com.soukue.pojo.greenyep.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author soukue
 * 2021/3/6
 */
@Data
public class CreateOrderResp implements Serializable {

    private static final long serialVersionUID = 3640876509105435407L;

    //官方订单编号
    private String txn_id;
    //价格 单位：元。精确小数点后2位。
    private BigDecimal amount;
    //支付金额
    private BigDecimal amount_pay;
    //支付过期时间，单位秒。
    private String timeout;
    //官方收银台地址
    private String cahier_url;
    //订单收款码地址。供商户自定义收银台使用。
    private String qrcode_url;
    //订单支付结果查询地址。
    private String query_url;
    //签名串
    private String signature;

}
