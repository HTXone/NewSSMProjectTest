package com.TestSys.Service.impl;

import com.TestSys.Service.MessageServcie;
import com.TestSys.entity.Message;
import com.TestSys.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageServcie {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> SelectMessageByID(int reciverID) {
        return messageMapper.SelectMessageByID(reciverID);
    }

    @Override
    public List<Message> SelectMessageBySenderID(int senderID) {
        return messageMapper.SelectMessageBySenderID(senderID);
    }

    @Override
    public int AddMessage(Message message) {
        return messageMapper.AddMessage(message);
    }
}
