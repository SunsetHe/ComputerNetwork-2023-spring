package New.Week7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static int BYTE_LNGTH =64;

    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("阻塞等待客户端连接中...");
        clientSocket = serverSocket.accept();
        InputStream is =clientSocket.getInputStream();
        for (;;){
            byte[] bytes = new byte[BYTE_LNGTH];
            int cnt = is.read(bytes,0,17);
            if (cnt>0){
                System.out.println("服务端已收到消息：" + new String(bytes).trim());
            }
        }
    }

    public void stop(){
        try {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

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
