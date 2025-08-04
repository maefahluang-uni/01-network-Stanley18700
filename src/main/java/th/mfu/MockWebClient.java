package th.mfu;

import java.io.*;
import java.net.*;

// call mockup server at port 8080

public class MockWebClient {
    public static void main(String[] args) {
        try (
            // TODO: Create a socket to connect to the web server on port 8080
            Socket socket = new Socket("localhost", 8080);

            // TODO: Create input and output streams for the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // TODO: Send an HTTP GET request to the web server
            String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
            out.print(request);
            out.flush();

            // Read the response from the web server and print out to console
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

            // Socket is auto-closed in try-with-resources
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
