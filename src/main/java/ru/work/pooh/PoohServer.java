package ru.work.pooh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.Provider;
import java.util.Arrays;
import java.util.HashMap;

public class PoohServer {
    private final HashMap<String, Service> modes = new HashMap<String, Service>();

    public void start() {
        System.out.println("Start");
        modes.put("queue", new QueueService());
        modes.put("topic", new TopicService());
//        ExecutorService poll = Executors.newFixedThreadPool(
//                Runtime.getRuntime().availableProcessors()
//        );

        try (ServerSocket server = new ServerSocket(9001)) {

            while (!server.isClosed()) {
                Socket socket = server.accept();
//                poll.execute(
//                        () -> {
                try (OutputStream out = socket.getOutputStream();
                     InputStream in = socket.getInputStream()) {
                    byte[] buff = new byte[1_000_000];
                    var total = in.read(buff);
                    var text = new String(Arrays.copyOfRange(buff, 0, total), StandardCharsets.UTF_8);
                    System.out.println("server text: " + text);
                    var req = new Req(text);
                    var resp = modes.get(req.mode()).process(req);
                    out.write(("HTTP/1.1 " + resp.getStatus() + " OK\\r\\n").getBytes());
                    out.write(resp.getText().getBytes());
//                                out.write(("HTTP/1.1 200 OK\\r\\n").getBytes());
//                                out.write(text.getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                        }
//                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new PoohServer().start();
    }

}
