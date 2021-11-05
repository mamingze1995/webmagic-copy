package com.mmz.webmagic.copy.model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * @Description: note
 * @Author: mamingze
 * @Date: 2021/11/5 18:35
 **/
public class HttpRequestBody implements Serializable {

    public static abstract class ContentType {

        public static final String JSON = "application/json";

        public static final String XML = "text/xml";

        public static final String FORM = "application/x-www-form-urlencoded";

        public static final String MULTIPART = "multipart/form-data";
    }

    private byte[] body;

    private String contentType;

    private String encoding;

    public HttpRequestBody() {
    }

    public HttpRequestBody(byte[] body, String contentType, String encoding) {
        this.body = body;
        this.contentType = contentType;
        this.encoding = encoding;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

//    public static HttpRequestBody json(String json, String encoding) {
//        return new HttpRequestBody(json.getBytes(), )
//    }
}
