import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author soukue
 * 2020/11/21
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(HttpRequest.get("http://localhost:8003/goods/11").execute().body());
//        ClassLoader bootstrapClassLoader;
//        System.out.println("1.0.8".replaceAll("\\.", ""));
//        System.out.println(ReUtil.isMatch("^([1-9]\\d|[1-9])(\\.([1-9]\\d|\\d))*$", "1.0.8"));
//        System.out.println(ReUtil.isMatch("^([1-9]\\d|[1-9])(\\.([1-9]\\d|\\d))*$", "1.0.10"));
//        System.out.println(ReUtil.isMatch("^(\\d)((\\.(\\d))?)$", "10101"));
        System.out.println(ReUtil.isMatch("^([1-9]\\d*(\\.\\d+){0,2})$", "1.1.1"));
//        System.out.println(ReUtil.isMatch("^([1-9]\\d|[1-9])(\\.([1-9]\\d|\\d)){?}$", "1.0.10"));
//        System.out.println(ReUtil.isMatch("^([1-9]\\d|[1-9])(\\.([1-9]\\d|\\d)){?}$", "1010"));
        System.out.println(Arrays.toString(HashUtil.cityHash128("abcdefsfsdf".getBytes(Charset.defaultCharset()))));

//        HttpUtil.post()
    }
}
