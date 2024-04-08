package New.Week9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileReceiver {
    public static void main(String[] args) throws IOException {
        File file = new File("checksum_recv.txt");
        FileOutputStream output = new FileOutputStream(file);
        byte[] data=new byte[1024];
        DatagramSocket ds=new DatagramSocket(9091);
        DatagramPacket dp=new DatagramPacket(data, data.length);

        int len;
        for(;;){
            ds.receive(dp);
            len = dp.getLength();
            if(len == 0){
                break;
            }
            output.write(data, 0, len);
        }
        output.close();
        ds.close();
        System.out.println("接收来自"+dp.getAddress().toString()+
                "的文件已完成！对方所使用的端口号为："+dp.getPort());
        file = new File("checksum_recv.txt");
        System.out.println("接收文件的md5为: " + MD5Util.getMD5(file));
    }

}
