package com.smscaster.SMS.Caster.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.smscaster.SMS.Caster.models.Documents;
import com.smscaster.SMS.Caster.models.ResponseMessage;
import com.smscaster.SMS.Caster.repositories.IDocumentRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/document")
public class DocumentController {

  @Autowired
  private IDocumentRepository documentRepository;

  public DocumentController(IDocumentRepository documentRepo) {
    this.documentRepository = documentRepo;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Documents GetById(@PathVariable("id") ObjectId id) {
    return this.documentRepository.findBy_id(id);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Documents> GetAll() {
    List<Documents> DocumentsList = this.documentRepository.findAll();
    return DocumentsList;
  }
  
  @PostMapping("/upload/{id}")
  public ResponseEntity<ResponseMessage> uploadFile(
    @PathVariable("id") String id,
    @ApiParam(name = "file", value = "Select the file to Upload", required = true)
    @RequestPart("file") MultipartFile file) throws IOException {
      Optional<Documents> doc = this.documentRepository.findById(id);
      if (!doc.isEmpty()) {
        Documents data = doc.get();
        data.setfile(new String(file.getBytes()));
        this.documentRepository.save(data);
        String message = "Uploaded the file successfully: ";
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Document not FOund"));
      }

  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Documents Insert(@RequestBody Documents model) {
    model.set_id(ObjectId.get());
    this.documentRepository.insert(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Documents Update(
    @PathVariable("id") ObjectId id,
    @Validated @RequestBody Documents model
  ) {
    model.set_id(id);
    this.documentRepository.save(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable ObjectId id) {
    this.documentRepository.delete(this.documentRepository.findBy_id(id));
  }
}
