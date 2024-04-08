package New.Week13;

import java.lang.reflect.Proxy;

public class RpcConsumer {
    public static void main(String[] args) {
        IProxy2 iProxy2 = (IProxy2) Proxy.newProxyInstance(
                IProxy2.class.getClassLoader(),
                new Class<?>[]{IProxy2.class},
                new IProxy2Handler()
        );

        System.out.println(iProxy2.sayHi("abc"));
    }
}
