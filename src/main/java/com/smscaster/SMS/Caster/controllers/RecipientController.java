package com.smscaster.SMS.Caster.controllers;

import com.smscaster.SMS.Caster.models.Recipients;
import com.smscaster.SMS.Caster.repositories.IRecipientRepository;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
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

  @ApiOperation(value = "Get get all recipients", nickname = "getRecipients")
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Recipients> GetAll() {
    List<Recipients> RecipientsList = this.recipientRepository.findAll();
    return RecipientsList;
  }

  @ApiOperation(value = "Insert some recipients", nickname = "addRecipients")
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public List<Recipients> Insert(@RequestBody List<Recipients> model) {
    List<Recipients> recipientList = this.recipientRepository.insert(model);
    return recipientList;
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

  @ApiOperation(value = "Delete all recipient", nickname = "deleteRecipients")
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public void deleteAll() {
    this.recipientRepository.deleteAll();
  }
}
