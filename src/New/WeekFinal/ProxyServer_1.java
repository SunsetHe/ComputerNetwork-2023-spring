package New.WeekFinal;

import java.io.IOException;
import java.net.ServerSocket;

public class ProxyServer_1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            new Thread(new ProxyThread_1(server.accept())).start();
        }
    }
}
