package ru.work.pooh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private Socket socket;
    private int num;


    public void run() {

        try (ServerSocket server = new ServerSocket(5006)) {
            System.out.println("Запуск сервера");

            while (true) {
                //ждем когда обратиться клиент
                Socket socket = server.accept();
                System.out.println("Server ждем когда обратиться клиент");

                //обрабатываем запрос
                System.out.println("Server обрабатываем запрос");
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("Server обрабатываем запрос try");
                    String answer = "Server 200 OK";
//                    while (!(str = in.readLine()).isEmpty()) {
//                        System.out.println(str);
//                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    //out.flush();
                    System.out.println("Server out.flush()");
                }
            }
        } catch (IOException e) {
            System.out.println("Server printStackTrace");
            e.printStackTrace();
        }
        System.out.println("Server end");
    }

}
