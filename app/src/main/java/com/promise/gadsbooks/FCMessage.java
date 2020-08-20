package com.promise.gadsbooks;

public class FCMessage {
    // Message message;
    String to;
    Data data;

    public FCMessage() {
    }

    public FCMessage(/*Message message,*/  String to, Data data) {
        //this.message = message;
        this.to = to;
        this.data = data;
    }

 /*   public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }*/

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
