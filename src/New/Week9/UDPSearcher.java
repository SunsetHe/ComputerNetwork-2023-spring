package New.Week9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSearcher {
    public static void main(String[] args) throws IOException {
        String sendData = MessageUtil.buildWithPort(30000);
        byte[] sendBytes = sendData.getBytes(StandardCharsets.UTF_8);
        DatagramSocket datagramSocket = new DatagramSocket(30000);
        DatagramPacket sendPacket = new DatagramPacket(sendBytes, 0,
                sendBytes.length,
                InetAddress.getByName("255.255.255.255"), 9091);
        datagramSocket.send(sendPacket);
        System.out.println("数据发送完毕...");

        byte[] buf_get = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buf_get,
                0, buf_get.length);
        datagramSocket.receive(receivePacket);
        int len = receivePacket.getLength();
        String data = new String(receivePacket.getData(),0, len);
        String tag = MessageUtil.parseTag(data);
        System.out.println(tag);

        datagramSocket.close();

    }
}
