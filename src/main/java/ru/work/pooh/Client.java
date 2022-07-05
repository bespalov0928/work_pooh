package ru.work.pooh;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;

    public Client(String address, Integer port) throws IOException {
        //устанавливаем соединение
        this.socket = new Socket(address, port);
        System.out.println("Client address: " + address + ", port: " + port);
    }

    public void start() throws IOException {

        //получаем входной и выходной потоки сокета для обмена сообщениями
        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();
        System.out.println("Client получаем входной и выходной потоки");


        //посылаем сообщение верверу
        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);
        System.out.println("Client посылаем сообщение cерверу");
        String line="reqwest";

        // Отсылаем строку серверу
        out.writeUTF(line);
        System.out.println("Client отправляем строку");
        //out.flush();

        //ждем ответа от сервера
        line = in.readUTF();
        System.out.println("Client line: " + line);

    }

}
