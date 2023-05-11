package New.Week7;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {
    private Socket clientSocket;
    private OutputStream out;
    private BufferedReader in;

    public void startConnection(String ip,int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = clientSocket.getOutputStream();
    }
    public void sendMessage(String msg) throws IOException{
        for (int i = 0;i < 10;i++){
            out.write(msg.getBytes());
        }
    }

    public void stopConnection(){
        try {
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("这里是客户端，连接已关闭");
        }
    }

    public static void main(String[] args) {
        int port = 9091;
        TCPClient client = new TCPClient();
        try {
            client.startConnection("127.0.0.1",port);
            String message = "network principle";
            client.sendMessage(message);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            client.stopConnection();
        }
    }
}
