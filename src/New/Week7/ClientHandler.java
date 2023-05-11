package New.Week7;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class ClientHandler extends Thread{
    private Socket socket;
    ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),
                    StandardCharsets.UTF_8),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),
                    StandardCharsets.UTF_8));
            String str = in.readLine();
            String Changestr = str.toUpperCase();
            System.out.println("我是服务端，客户端说：" + str);
            out.println("修改后为 "+Changestr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
