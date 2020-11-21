import cn.hutool.http.HttpRequest;

/**
 * @author dengwenlong
 * 2020/11/21
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(HttpRequest.get("http://localhost:8003/goods/11").execute().body());
    }
}
