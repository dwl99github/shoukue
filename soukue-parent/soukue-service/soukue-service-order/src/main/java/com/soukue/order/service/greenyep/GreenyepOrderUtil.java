package com.soukue.order.service.greenyep;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Maps;
import com.soukue.pojo.greenyep.reqest.CreateOrderReq;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * @author dengwenlong
 * 2021/3/7
 */
public class GreenyepOrderUtil {

    public static final String CREATE_ORDER_URL = "https://www.greenyep.com/api/transaction/create";
    public static final String QUERY_ORDER_URL = "https://www.greenyep.com/api/transaction/create";
    public static final String UID = "7506423852228300";
    public static final String TOKEN = "fidn1uvmdbd19czzx1nda07vai35t67z";

    public String createOrder(CreateOrderReq createOrderReq){
        createOrderReq.setUid(UID);
        Map<String, Object> mapParams = Maps.newHashMap();
        //        toLowerCase(md5(uid + amount + type + account + order_id + customer_id + product_name + notify_url + redirect_url + token))
        String signature = SecureUtil.md5(UID + createOrderReq.getAmount() + createOrderReq.getType() + createOrderReq.getOrder_id() + createOrderReq.getNotify_url() + TOKEN);
        createOrderReq.setSignature(signature);
        BeanUtil.copyProperties(createOrderReq, mapParams, CopyOptions.create().ignoreNullValue());
        return HttpUtil.post(CREATE_ORDER_URL, mapParams);
    }

}
