package com.TestSys.Service;

import com.TestSys.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MessageServcie {

    List<Message> SelectMessageByID(int reciverID);
    int AddMessage(Message message);
}
