package com.smscaster.SMS.Caster.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.smscaster.SMS.Caster.models.Documents;
import com.smscaster.SMS.Caster.models.ResponseMessage;
import com.smscaster.SMS.Caster.repositories.IDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sms-api/document")
public class DocumentController {

  @Autowired
  private IDocumentRepository documentRepository;

  public DocumentController(IDocumentRepository documentRepo) {
    this.documentRepository = documentRepo;
  }

  @ApiOperation(value = "Get document by id", nickname = "getDocument")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Documents GetById(@PathVariable("id") String id) {
    return this.documentRepository.findBy_id(id);
  }

  @ApiOperation(value = "Get get all documents", nickname = "getDocuments")
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Documents> GetAll() {
    List<Documents> DocumentsList = this.documentRepository.findAll();
    return DocumentsList;
  }

  @PostMapping("/upload/{id}")
  @ApiOperation(value = "upload some documents", nickname = "uploadDocument")
  public ResponseEntity<ResponseMessage> uploadFile(@PathVariable("id") String id,
      @ApiParam(name = "file", value = "Select the file to Upload", required = true) @RequestPart("file") MultipartFile file)
      throws IOException {
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

  @ApiOperation(value = "Insert some documents", nickname = "addDocument")
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Documents Insert(@RequestBody Documents model) {
    this.documentRepository.insert(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Documents Update(@PathVariable("id") String id, @Validated @RequestBody Documents model) {
    this.documentRepository.save(model);
    return model;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void Delete(@PathVariable String id) {
    this.documentRepository.delete(this.documentRepository.findBy_id(id));
  }
}
