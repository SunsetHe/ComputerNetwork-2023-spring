import New.Week4.*;
import New.Week5.MyThreadTask2;
import New.Week5.MythreadTask3;
import New.Week5.PlusMinusOne;
import New.Week5.ProductFactory;
import New.Week7.TCPServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        int port = 9091;
        TCPServer server = new TCPServer();
        try {
            server.start(port);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            server.stop();
        }
    }
}