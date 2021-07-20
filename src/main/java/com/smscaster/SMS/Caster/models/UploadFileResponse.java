package com.smscaster.SMS.Caster.models;

import lombok.Data;

@Data
public class UploadFileResponse {

  private String fileName;
  private String fileDownloadUri;
  private String fileType;
  private long size;

  public UploadFileResponse(
    String fileName,
    String fileDownloadUri,
    String fileType,
    long size
  ) {
    this.setFileName(fileName);
    this.setFileDownloadUri(fileDownloadUri);
    this.setFileType(fileType);
    this.setSize(size);
  }

public long getSize() {
    return size;
}

public void setSize(long size) {
    this.size = size;
}

public String getFileType() {
    return fileType;
}

public void setFileType(String fileType) {
    this.fileType = fileType;
}

public String getFileDownloadUri() {
    return fileDownloadUri;
}

public void setFileDownloadUri(String fileDownloadUri) {
    this.fileDownloadUri = fileDownloadUri;
}

public String getFileName() {
    return fileName;
}

public void setFileName(String fileName) {
    this.fileName = fileName;
}
}
