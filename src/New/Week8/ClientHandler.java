package New.Week8;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;
    private final ClientReadHandler clientReadHandler;
    private final ClientWriteHandler clientWriteHandler;

    ClientHandler(Socket socket) throws IOException{
        this.socket = socket;
        this.clientReadHandler = new ClientReadHandler(socket.getInputStream());
        this.clientWriteHandler = new ClientWriteHandler(socket.getOutputStream());
    }

    @Override
    public void run() {
        super.run();
        clientReadHandler.start();
        clientWriteHandler.start();
    }
}
