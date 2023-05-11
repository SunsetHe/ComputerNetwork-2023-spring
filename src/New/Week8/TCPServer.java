package New.Week8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
    private ServerSocket serverSocket;
    private List<Socket> clientsockets = new ArrayList<>();
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("阻塞等待客户端连接中...");
        for (;;){
            Socket socket = serverSocket.accept();
            clientsockets.add(socket);
            ClientHandler ch = new ClientHandler(socket);
            ch.start();
            System.out.println();
        }
    }

    private void sendMessageToAllClients(String message){
        for (Socket clientsocket : clientsockets){
            try {
                clientsocket.getOutputStream().write(message.getBytes());
            }catch (IOException e){
                e.printStackTrace();
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
