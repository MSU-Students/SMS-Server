package com.smscaster.SMS.Caster.controllers;

import java.util.List;

import com.smscaster.SMS.Caster.models.Officers;
import com.smscaster.SMS.Caster.repositories.IOfficerRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sms-api/officer")
public class OfficerController {

  @Autowired
  private IOfficerRepository officerRepository;

  public OfficerController(IOfficerRepository officerRepo) {
    this.officerRepository = officerRepo;
  }

  @ApiOperation(value = "Get officer by id", nickname = "getOfficer")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Officers GetById(@PathVariable("id") ObjectId id) {
    return this.officerRepository.findBy_id(id);
  }

  @ApiOperation(value = "Get get all officers", nickname = "getOfficers")
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Officers> GetAll() {
    List<Officers> OfficersList = this.officerRepository.findAll();
    return OfficersList;
  }

  @ApiOperation(value = "Insert some officer", nickname = "addAccount")
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Officers Insert(@RequestBody Officers model) {
    model.set_id(ObjectId.get());
    this.officerRepository.insert(model);
    return model;
  }

  @ApiOperation(value = "Update this officer", nickname = "updateOfficer")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Officers Update(@PathVariable("id") ObjectId id, @Validated @RequestBody Officers model) {
    model.set_id(id);
    this.officerRepository.save(model);
    return model;
  }

  @ApiOperation(value = "Delete this officer", nickname = "deleteOfficer")
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable ObjectId id) {
    this.officerRepository.delete(this.officerRepository.findBy_id(id));
  }
}
