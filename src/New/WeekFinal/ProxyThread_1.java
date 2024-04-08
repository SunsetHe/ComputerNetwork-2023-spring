package New.WeekFinal;

import java.io.*;
import java.net.*;


public class ProxyThread_1 implements Runnable{
    final static int BUFFER_SIZE = 32768;
    Socket client;

    public ProxyThread_1(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            DataOutputStream toClient = new DataOutputStream(client.getOutputStream());
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String request = fromClient.readLine();
            String[] tokens = request.split(" ");
            String method = tokens[0];
            String url = tokens[1];
            URL siteUrl = new URL(url);
            System.out.println("Request for : " + method + " " + url + " received.");

            if (!"GET".equals(method)) {
                System.out.println("Only GET method supported. Discarded.");
                return;
            }

            HttpURLConnection conn = (HttpURLConnection) siteUrl.openConnection();
            conn.setRequestMethod(method);

            for (String line; (line = fromClient.readLine()) != null;) {
                if (line.isEmpty())
                    break;
                conn.addRequestProperty(line.split(":")[0], line.split(":")[1]);
            }

            InputStream proxyToClientIS = conn.getInputStream();
            byte by[] = new byte[ BUFFER_SIZE ];
            int index = proxyToClientIS.read(by, 0, BUFFER_SIZE);
            while (index != -1) {
                toClient.write(by, 0, index);
                index = proxyToClientIS.read(by, 0, BUFFER_SIZE);
            }

            proxyToClientIS.close();
            toClient.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
