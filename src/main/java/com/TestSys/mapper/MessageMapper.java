package com.TestSys.mapper;

import com.TestSys.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Select("select * from message where reciverID = #{reciverID}")
    @Results(id = "messageMap",value = {

            @Result(id = true,column = "messageID",property = "messageID"),
            @Result(column = "SenderID",property = "senderID"),
            @Result(column = "ReciverID",property = "reciverID"),
            @Result(column = "Message",property = "message")
    })
    List<Message> SelectMessageByID(int ReciverID);

    @Insert("insert into message (SenderID,ReciverID,Message,messageID) values (#{senderID},#{reciverID},#{message},#{messageID})")
    int AddMessage(Message message);

    @Select("select * from message where senderID = #{SenderID}")
    @ResultMap("messageMap")
    List<Message> SelectMessageBySenderID(int SenderID);
}
