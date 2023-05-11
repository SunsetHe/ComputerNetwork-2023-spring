package New.Week8;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {
    private Socket clientSocket;
    private OutputStream out;
    private BufferedReader in;
    ClientHandler clientHandler;
    ClientWriteHandler clientWriteHandler;
    ClientReadHandler clientReadHandler;

    public void startConnection(String ip,int port) throws IOException,InterruptedException {
        clientSocket = new Socket(ip, port);
        while (true){
            clientHandler = new ClientHandler(clientSocket);
            clientHandler.start();
            Thread.sleep(100000);
        }
//        for (;;){
//            clientHandler = new ClientHandler(clientSocket);
//            clientReadHandler = new ClientReadHandler(clientSocket.getInputStream());
//            clientWriteHandler = new ClientWriteHandler(clientSocket.getOutputStream());
//            clientWriteHandler.start();
//            clientReadHandler.start();
//            clientReadHandler.join();
//        }
    }

//    public void sendMessage(String msg) throws IOException{
//        clientHandler.
//    }

    public void stopConnection(){
        try {
            if (clientSocket != null) clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("这里是客户端，连接已关闭");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int port = 9091;
        TCPClient client = new TCPClient();
        try {
            client.startConnection("127.0.0.1",port);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            client.stopConnection();
        }
    }
}
