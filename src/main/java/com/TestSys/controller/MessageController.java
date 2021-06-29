package com.TestSys.controller;

import com.TestSys.Service.MessageServcie;
import com.TestSys.entity.Classes;
import com.TestSys.entity.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageServcie messageServcie;

    @RequestMapping("/MessageList.do")
    public String FindMessages(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam("param") int userID, Model model){
        Integer pageSize = 3;
        PageHelper.clearPage();
        PageHelper.startPage(pageNo, pageSize);
        List<Message> messages = messageServcie.SelectMessageByID(userID);
        PageInfo<Message> pageInfo = new PageInfo<>(messages);

        model.addAttribute("messages",messages);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/MessageList.do");
        model.addAttribute("param1",userID);
        return "simpleMessageList.jsp";
    }

    public String AddMessages(Message message,Model model){
        messageServcie.AddMessage(message);
        return this.FindMessages(1, message.getSenderID(), model);
    }


}
