package com.wuyi.express.fnpt.request;

public class UploadFileRequest extends Request {
    String file_type;
    String file_binary;

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_binary() {
        return file_binary;
    }

    public void setFile_binary(String file_binary) {
        this.file_binary = file_binary;
    }
}
