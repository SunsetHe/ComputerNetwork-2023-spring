package New.Week9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.UUID;

public class UDPProvider {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9091);
        byte[] buf = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buf,0,
                buf.length);
        System.out.println("阻塞等待发送者的消息...");
        datagramSocket.receive(receivePacket);

        int len = receivePacket.getLength();
        String data = new String(receivePacket.getData(),0, len);
        System.out.println("收到的消息为："+data);
        String ip = receivePacket.getAddress().getHostAddress();
        int port = MessageUtil.parsePort(data);
        byte[] buf_res = new byte[1024];
        String tag = UUID.randomUUID().toString();
        String res = MessageUtil.buildWithTag(tag);
        len = res.length();
        buf_res = res.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(buf_res, 0,
                len, InetAddress.getByName(ip), port);
        datagramSocket.send(sendPacket);


        datagramSocket.close();
    }
}
