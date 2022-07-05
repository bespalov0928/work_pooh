package ru.work.pooh;

import java.security.Provider;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TopicService implements Service {
    ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map = new ConcurrentHashMap();

    @Override
    public Resp process(Req req) {
        final String POST = "POST";
        final String GET = "GET";

        String text = "";
        int status = 200;
        String nameQueue = "WEATHER";
        map.putIfAbsent(nameQueue, new ConcurrentLinkedQueue<String>());
        if (req.method().toUpperCase().equals(POST)) {
            text = processPost(nameQueue, req);
        } else if (req.method().toUpperCase().equals(GET)) {
            text = processGet(nameQueue, status);
        }
        Resp resp = new Resp(text, status);
        return resp;
    }

    private String processPost(String nameQueue, Req req) {
        String text = "";
        map.get(nameQueue).add(req.getText());
        text = req.getText() + " : OK";
        return text;
    }

    private String processGet(String nameQueue, int status) {
        String text = "";
        ConcurrentLinkedQueue<String> linkUser = new ConcurrentLinkedQueue<String>();
        linkUser.addAll(map.getOrDefault(nameQueue, new ConcurrentLinkedQueue<String>()));
        text = linkUser.poll();
        if (text == null || text.equals("")) {
            status = 999;
            text = "not date";
        }
        return text;
    }

}
