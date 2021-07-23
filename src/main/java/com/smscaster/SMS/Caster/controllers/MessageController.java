package com.smscaster.SMS.Caster.controllers;

import java.util.List;

import com.smscaster.SMS.Caster.models.Message;
import com.smscaster.SMS.Caster.repositories.IMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sms-api/message")


public class MessageController {
    @Autowired
    private IMessageRepository messageRepository;

    public MessageController(IMessageRepository messageRepo) {
        this.messageRepository = messageRepo;
    }

    @ApiOperation(value = "Get get all messages", nickname = "GetMessages")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Message> GetAll() {
      List<Message> MessageList = this.messageRepository.findAll();
      return MessageList;
    }

    @ApiOperation(value = "Insert some message", nickname = "AddMessage")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Message Insert(@RequestBody Message model) {
        this.messageRepository.insert(model);
        return model;
    }
}
