package ru.work.pooh;

public class Req {
    private final String text;
    private String mode = "";
    private String method = "";
    private String nameQueue = "";
    private String value = "";

    public Req(String text) {
        this.text = text;
        this.mode = setMode();
        this.method = setMethod();
        this.nameQueue = setNameQueue();

    }

    public void setValueOf(String key) {
        String str = "";
        String[] arrFirst = text.toUpperCase().split(key);
        if (arrFirst.length > 1) {
            str = arrFirst[1];
            str = str.replace("=", "");
            str = str.replace(" ", "");
            this.value = str;
        }
    }

    /**
     * queue, topic
     * @return
     */
    private String setMode() {

        String textTemp = text.replace(" ", "");
        String[] arrFirst = textTemp.split("\r\n");
        if (arrFirst.length == 0) {
            return "";
        }
        String str = arrFirst[0];
        String[] arrSecond = str.split("/");
        if (arrSecond.length == 0) {
            return "";
        }
        return arrSecond[1];
    }

    /**
     * get, post
     * @return
     */
    private String setMethod() {

        String[] arrFirst = text.split(" ");
        if (arrFirst.length < 2) {
            return "";
        }
        String str = arrFirst[0];
        return str;
    }

    /**
     * weather
     * @return
     */
    private String setNameQueue() {
        String[] arrFirst = text.split(" ");
        if (arrFirst.length < 2) {
            return "";
        }
        String strFirst = arrFirst[1];

        String[] arrSecond = strFirst.split("/");
        if (arrSecond.length < 2) {
            return "";
        }
        String str = arrSecond[2];
        return str;
    }

    public String getText() {
        return text;
    }

    public String mode() {
        return mode;
    }

    public String method() {
        return method;
    }

    public String getNameQueue() {
        return nameQueue;
    }

}
