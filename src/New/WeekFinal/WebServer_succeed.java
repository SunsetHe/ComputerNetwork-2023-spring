package New.WeekFinal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer_succeed {

    private static final String DEFAULT_FILE = "/index.html";
    private static final String ERROR_FILE = "/404.html";
    private static final String SHUTDOWN_COMMAND = "/shutdown";

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> handleRequest(socket));
            }
        }
    }

    private static void handleRequest(Socket socket) {
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedOutputStream dataOut = null;
        String fileRequested = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            dataOut = new BufferedOutputStream(socket.getOutputStream());

            String input = in.readLine();
            String[] request = input.split(" ");
            String method = request[0];
            fileRequested = request[1];

            if (fileRequested.equals(SHUTDOWN_COMMAND)) {
                out.println("HTTP/1.1 200 OK");
                out.println("Server: Java HTTP Server");
                out.println("Date: " + new Date());
                out.println();
                out.flush();
                System.exit(0);
            }

            if (fileRequested.endsWith("/")) {
                fileRequested += DEFAULT_FILE;
            }

            File file = new File("www", fileRequested);
            int fileLength = (int) file.length();
            byte[] fileData = readFileData(file, fileLength);

            out.println("HTTP/1.1 200 OK");
            out.println("Server: Java HTTP Server");
            out.println("Date: " + new Date());
            out.println("Content-length: " + fileLength);
            out.println();
            out.flush();

            dataOut.write(fileData, 0, fileLength);
            dataOut.flush();

        } catch (FileNotFoundException fnfe) {
            try {
                fileNotFound(out, dataOut, fileRequested);
            } catch (IOException ioe) {
                System.err.println("Error with file not found exception : " + ioe.getMessage());
            }
        } catch (IOException ioe) {
            System.err.println("Server error : " + ioe);
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (dataOut != null) dataOut.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }
        }
    }

    private static byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        return fileData;
    }

    private static void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException {
        File file = new File("www", ERROR_FILE);
        int fileLength = (int) file.length();
        String contentMimeType = "text/html";
        byte[] fileData = readFileData(file, fileLength);

        out.println("HTTP/1.1 404 File Not Found");
        out.println("Server: Java HTTP Server");
        out.println("Date: " + new Date());
        out.println("Content-type: " + contentMimeType);
        out.println("Content-length: " + fileLength);
        out.println();
        out.flush();

        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();
    }
}
