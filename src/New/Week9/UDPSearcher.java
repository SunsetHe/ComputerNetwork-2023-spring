package New.Week9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSearcher {
    public static void main(String[] args) throws IOException {
        String sendData = "Username:admin;key:123";
        byte[] sendBytes = sendData.getBytes(StandardCharsets.UTF_8);
        DatagramSocket datagramSocket = new DatagramSocket(9092);
        DatagramPacket sendPacket = new DatagramPacket(sendBytes,
                0,sendBytes.length, InetAddress.getLocalHost(),
                9091);
        datagramSocket.send(sendPacket);
        System.out.println("数据发送完毕");

        byte[] bytes = new byte[1024];
        DatagramPacket receicePacket = new DatagramPacket(bytes,0,
                bytes.length);
        datagramSocket.receive(receicePacket);
        System.out.println("接收到"+
                receicePacket.getAddress().getHostAddress()+" :"+
                receicePacket.getPort()+"消息"+
                new String(receicePacket.getData(),0, receicePacket.getLength()));
        datagramSocket.close();
    }
}
