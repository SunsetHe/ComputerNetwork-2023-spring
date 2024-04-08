package New.Week13;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcProvider {
    public static void main(String[] args) {
        Proxy2Impl proxy2 = new Proxy2Impl();

        try (ServerSocket serverSocket = new ServerSocket()){
            serverSocket.bind(new InetSocketAddress(9091));
            try(Socket socket = serverSocket.accept()) {
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

                String methodName = is.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) is.readObject();
                Object[] arguments = (Object[]) is.readObject();

                Object result = Proxy2Impl.class.getMethod(
                        methodName,
                        parameterTypes
                ).invoke(proxy2,arguments);

                new ObjectOutputStream(socket.getOutputStream()).writeObject(result);

            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
