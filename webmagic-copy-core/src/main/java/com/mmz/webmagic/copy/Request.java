package com.mmz.webmagic.copy;

import com.mmz.webmagic.copy.annotation.Experimental;
import com.mmz.webmagic.copy.downloader.Downloader;
import com.mmz.webmagic.copy.model.HttpRequestBody;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: object contains url to crawl
 *               it contains some addtional information.
 * @Author: mamingze
 * @Date: 2021/11/5 12:12
 **/
public class Request implements Serializable {

    public static final String CYCLE_TRIED_TIMES = "_cycle_tried_times";

    private String url;

    private String method;

    private HttpRequestBody requestBody;

    /**
     * this req use this downloader
     */
    private Downloader downloader;

    /**
     * Store addtional information in extras.
     */
    private Map<String, Object> extras;

    /**
     * cookies for current url, if not set use Site's cookie.
     */
    private Map<String, String> cookies = new HashMap<>();

    private Map<String, String> headers = new HashMap<>();

    /**
     * Priority of the request.
     * The bigger will be processed earlier.
     * @see /TODO: 2021/11/9 us.codecraft.webmagic.scheduler.PriorityScheduler
     */
    private long priority;

    /**
     * when it is set to TRUE, the downloader will not try to parse response body to text.
     */
    private boolean binaryContent = false;

    private String charset;

    public Request() {}

    public Request(String url) {
        this.url = url;
    }

    public long getPriority() {
        return priority;
    }

    /**
     * Set the priority of request for sorting.
     * Need a scheduler supporting priority.
     * @See TODO: 2021/11/9 us.codecraft.webmagic.scheduler.PriorityScheduler
     *
     * @param priority
     * @return
     */
    @Experimental
    public Request setPriority(long priority) {
        this.priority = priority;
        return this;
    }

    // TODO <T>
    public Object getExtras(String key) {
        if (null == extras ) {
            return null;
        }
        return extras.get(key);
    }

    public Request putExtras(String key, Object value) {
        if (null == extras) {
            extras = new HashMap<>();
        }
        extras.put(key, value);
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * the http method of the request. the default is Get.
     * @return httpMethod
     * @See com.mmz.webmagic.copy.constant.HttpConstant.Method
     */
    public String getMethod() {
        return method;
    }

    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public Request addCookies(String key, String value) {
        cookies.put(key, value);
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Request addHeaders(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public HttpRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(HttpRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public boolean isBinaryContent() {
        return binaryContent;
    }

    public Request setBinaryContent(boolean binaryContent) {
        this.binaryContent = binaryContent;
        return this;
    }

    public Downloader getDownloader() {
        return downloader;
    }

    public void setDownloader(Downloader downloader) {
        this.downloader = downloader;
    }

    public String getCharset() {
        return charset;
    }

    public Request setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return priority == request.priority && binaryContent == request.binaryContent && Objects.equals(url, request.url) && Objects.equals(method, request.method) && Objects.equals(requestBody, request.requestBody) && Objects.equals(downloader, request.downloader) && Objects.equals(extras, request.extras) && Objects.equals(cookies, request.cookies) && Objects.equals(headers, request.headers) && Objects.equals(charset, request.charset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method, requestBody, downloader, extras, cookies, headers, priority, binaryContent, charset);
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", requestBody=" + requestBody +
                ", downloader=" + downloader +
                ", extras=" + extras +
                ", cookies=" + cookies +
                ", headers=" + headers +
                ", priority=" + priority +
                ", binaryContent=" + binaryContent +
                ", charset='" + charset + '\'' +
                '}';
    }
}

