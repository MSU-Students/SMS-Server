package com.smscaster.SMS.Caster.controllers;

import java.util.List;

import com.smscaster.SMS.Caster.models.Officers;
import com.smscaster.SMS.Caster.repositories.IOfficerRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/officer")
public class OfficerController {

  @Autowired
  private IOfficerRepository officerRepository;

  public OfficerController(IOfficerRepository officerRepo) {
    this.officerRepository = officerRepo;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Officers GetById(@PathVariable("id") ObjectId id) {
    return this.officerRepository.findBy_id(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Officers> GetAll() {
    List<Officers> OfficersList = this.officerRepository.findAll();
    return OfficersList;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Officers Insert(@RequestBody Officers model) {
    model.set_id(ObjectId.get());
    this.officerRepository.insert(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Officers Update(
    @PathVariable("id") ObjectId id,
    @Validated @RequestBody Officers model
  ) {
    model.set_id(id);
    this.officerRepository.save(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable ObjectId id) {
    this.officerRepository.delete(this.officerRepository.findBy_id(id));
  }
}
