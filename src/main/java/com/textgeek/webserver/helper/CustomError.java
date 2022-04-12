package com.textgeek.webserver.helper;

public class CustomError {

    String MessageError;

    public CustomError(String Message) {
        this.MessageError = Message;
    }

    public String getMessageError() {
        return MessageError;
    }

    public void setMessageError(String MessageError) {
        this.MessageError = MessageError;
    }
}
