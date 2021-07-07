package com.smscaster.SMS.Caster.controllers;

import java.util.List;

import com.smscaster.SMS.Caster.models.Messages;
import com.smscaster.SMS.Caster.repositories.IMessageRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-api/message")
public class MessageController {

  @Autowired
  private IMessageRepository MessageRepository;

  public MessageController(IMessageRepository messageRepo) {
    this.MessageRepository = messageRepo;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Messages GetById(@PathVariable("id") ObjectId id) {
    return this.MessageRepository.findBy_id(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Messages> GetAll() {
    List<Messages> MessagesList = this.MessageRepository.findAll();
    return MessagesList;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Messages Insert(@RequestBody Messages model) {
    model.set_id(ObjectId.get());
    this.MessageRepository.insert(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Messages Update(
    @PathVariable("id") ObjectId id,
    @Validated @RequestBody Messages model
  ) {
    model.set_id(id);
    this.MessageRepository.save(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable ObjectId id) {
    this.MessageRepository.delete(this.MessageRepository.findBy_id(id));
  }
}
