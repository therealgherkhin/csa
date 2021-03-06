package uebung2.aufgabe8;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server extends Thread{


    public void run() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/index.html", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Der Server läuft... unter: localhost:8000/index.html");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Java Webserver</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<center><h1>Wilkommen auf meinem WebServer</h1></center>\n" +
                    "<center><p>Dies ist ein WebServer, welcher mithilfe der Klasse HttpServer implementiert wurde</p></center>\n"+"<center><img src=\"https://media.giphy.com/media/blSTtZehjAZ8I/giphy.gif\" alt=\"this slowpoke moves\"  width=250/></center>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
