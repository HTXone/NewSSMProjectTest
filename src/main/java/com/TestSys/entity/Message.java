package com.TestSys.entity;

public class Message {
    Integer messageID;
    Integer senderID;
    Integer reciverID;
    String message;

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", senderID=" + senderID +
                ", reciverID=" + reciverID +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getSenderID() {
        return senderID;
    }

    public void setSenderID(Integer senderID) {
        this.senderID = senderID;
    }

    public Integer getReciverID() {
        return reciverID;
    }

    public void setReciverID(Integer reciverID) {
        this.reciverID = reciverID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
