package New.Week9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPProvider {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9091);
        byte[] buf = new byte[1024];
        DatagramPacket receicePacket = new DatagramPacket(buf,0,
                buf.length);
        System.out.println("阻塞等待发送者的消息...");
        datagramSocket.receive(receicePacket);

        String ip = receicePacket.getAddress().getHostAddress();
        int port = receicePacket.getPort();
        int len = receicePacket.getLength();
        String data = new String(receicePacket.getData(),0,len);
        System.out.println("我是接收者，"+ip+":"+port+"的发送者说"+data);

        DatagramPacket sendPacket = new DatagramPacket(
                receicePacket.getData(),0,len,
                InetAddress.getLocalHost(),9092);
        datagramSocket.send(sendPacket);

        datagramSocket.close();
    }
}
