package ru.work.pooh;

public class Resp {
    private final String text;
    private final int status;


    public Resp(String text, int status) {
        this.text = text;
        this.status = status;
    }

    /**
     * temperature=18
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * 200
     * @return
     */
    public int getStatus() {
        return status;
    }

}
