package com.smscaster.SMS.Caster.controllers;

import com.smscaster.SMS.Caster.models.UploadFileResponse;
import com.smscaster.SMS.Caster.services.FileStorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sms-api/file")
public class FileController {

  private static final Logger logger = LoggerFactory.getLogger(
    FileController.class
  );

  @Autowired
  private FileStorageService fileStorageService;

  @ApiOperation(value = "Upload one file", nickname = "UploadFile")
  @PostMapping("/uploadFile")
  public UploadFileResponse uploadFile(
    @RequestPart("file") @ApiParam(
      value = "File",
      required = true
    ) MultipartFile file
  ) {
    String fileName = fileStorageService.storeFile(file);

    String fileDownloadUri = ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("sms-api/file/downloadFile/")
      .path(fileName)
      .toUriString();

    return new UploadFileResponse(
      fileName,
      fileDownloadUri,
      file.getContentType(),
      file.getSize()
    );
  }

  @ApiOperation(value = "Download file by file name", nickname = "DownloadFile")
  @GetMapping("/downloadFile/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(
    @PathVariable String fileName,
    HttpServletRequest request
  ) {
    // Load file as Resource
    Resource resource = fileStorageService.loadFileAsResource(fileName);

    // Try to determine file's content type
    String contentType = null;
    try {
      contentType =
        request
          .getServletContext()
          .getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      logger.info("Could not determine file type.");
    }

    // Fallback to the default content type if type could not be determined
    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity
      .ok()
      .contentType(MediaType.parseMediaType(contentType))
      .header(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + resource.getFilename() + "\""
      )
      .body(resource);
  }
}
