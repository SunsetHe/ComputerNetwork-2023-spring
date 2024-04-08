package New.Week13;

public class Proxy2Impl implements IProxy2{
    @Override
    public String sayHi(String s) {
        /*String a = Long.toString(s);*/
        return "Hello,user_id: " + s;
    }
}
