package New.Week13;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        PersonA personA = new PersonA();

        IProxy proxy = (IProxy) Proxy.newProxyInstance(
                personA.getClass().getClassLoader(),
                personA.getClass().getInterfaces(),
                new DynamicProxy(personA)
        );

        /*IProxy proxy = new PersonB(personA);*/

        proxy.submit();
    }
}
