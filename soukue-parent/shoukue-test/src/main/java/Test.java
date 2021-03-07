import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Maps;
import com.soukue.pojo.greenyep.reqest.CreateOrderReq;
import com.sun.deploy.net.HttpUtils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;

/**
 * @author soukue
 * 2020/11/15
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
//        System.out.println(InetAddress.getLocalHost());

        String url = "https://www.greenyep.com/api/transaction/create";
        String uid = "7506423852228300";
        int amount = 2;
//        BigDecimal bigDecimal = new BigDecimal(amount * 1.0 / 100).setScale(2, BigDecimal.ROUND_UP);
        BigDecimal bigDecimal = new BigDecimal(amount * 1.0 / 100).setScale(2, BigDecimal.ROUND_HALF_UP);

        int type = 2;
        String orderId = UUID.randomUUID().toString();
        String notifyUrl = "http://www.baidu.com";
        String token = "fidn1uvmdbd19czzx1nda07vai35t67z";
        Map<String, Object> mapParams = Maps.newHashMap();
//        toLowerCase(md5(uid + amount + type + account + order_id + customer_id + product_name + notify_url + redirect_url + token))
        String signature = SecureUtil.md5(uid + bigDecimal.toString() + type + orderId + notifyUrl + token);

        CreateOrderReq createOrderReq = new CreateOrderReq();
        createOrderReq.setUid(uid);
        createOrderReq.setAmount(bigDecimal);
        createOrderReq.setType(type);
        createOrderReq.setOrder_id(orderId);
        createOrderReq.setNotify_url(notifyUrl);
        createOrderReq.setSignature(signature);
        BeanUtil.copyProperties(createOrderReq, mapParams, CopyOptions.create().ignoreNullValue());

        String result = HttpUtil.post(url, mapParams);
        System.out.println(createOrderReq.getSignature());
        System.out.println(result);

    }
}
