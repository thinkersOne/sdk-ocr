package com.ocr.common.req;

/**
 * ocr请求 入参
 */
public class OcrRequest {
    private String host;
    private String path;
    private String imgFile;
    private String side;

    public OcrRequest() {
    }

    public OcrRequest(String host, String path, String imgFile, String side) {
        this.host = host;
        this.path = path;
        this.imgFile = imgFile;
        this.side = side;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
