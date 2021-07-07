package com.smscaster.SMS.Caster.controllers;

import java.util.List;

import com.smscaster.SMS.Caster.models.Recipients;
import com.smscaster.SMS.Caster.repositories.IRecipientRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-api/recipient")
public class RecipientController {

  @Autowired
  private IRecipientRepository recipientRepository;

  public RecipientController(IRecipientRepository recipientRepo) {
    this.recipientRepository = recipientRepo;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Recipients GetById(@PathVariable("id") ObjectId id) {
    return this.recipientRepository.findBy_id(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Recipients> GetAll() {
    List<Recipients> RecipientsList = this.recipientRepository.findAll();
    return RecipientsList;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Recipients Insert(@RequestBody Recipients model) {
    model.set_id(ObjectId.get());
    this.recipientRepository.insert(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Recipients Update(
    @PathVariable("id") ObjectId id,
    @Validated @RequestBody Recipients model
  ) {
    model.set_id(id);
    this.recipientRepository.save(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable ObjectId id) {
    this.recipientRepository.delete(this.recipientRepository.findBy_id(id));
  }
}
