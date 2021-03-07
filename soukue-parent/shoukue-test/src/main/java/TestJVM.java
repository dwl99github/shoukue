/**
 * @author soukue
 * 2021/2/7
 */
public class TestJVM {
    public static void main(String[] args) throws InterruptedException {
        testGC();
    }

    public static void testGC() throws InterruptedException {
        //JVM参数
        //打印参数  -XX:+PrintGCDetails
        byte[] a1,a2,a3,a4,a5;
        a1 = new byte[60000 * 1024];
//        a2 = new byte[300 * 1024];
        Thread.sleep(Integer.MAX_VALUE);
    }

}
