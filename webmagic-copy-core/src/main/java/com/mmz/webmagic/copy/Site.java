package com.mmz.webmagic.copy;

import com.mmz.webmagic.copy.constant.HttpConstant;

import java.util.*;

/**
 * @Description: note
 * @Author: mamingze
 * @Date: 2021/10/25 22:21
 **/
public class Site {

    private String domain;

    private String userAgent;

    private Map<String, String> defaultCookies = new LinkedHashMap<>();

    private Map<String, Map<String, String>> cookies = new HashMap<>();

    private String charset;

    private int sleepTime = 5000;

    private int retryTimes = 0;

    private int cycleRetryTimes = 0;

    private int retrySleepTime = 1000;

    private int timeOut = 5000;

    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<>();

    private Set<Integer> acceptStatCode = DEFAULT_STATUS_CODE_SET;

    private Map<String, String> headers = new HashMap<>();

    private boolean useGzip = true;

    private boolean disableCookieManagement = false;

    static {
        DEFAULT_STATUS_CODE_SET.add(HttpConstant.StatusCode.CODE_200);
    }

    /**
     * new a site
     * @return Site
     */
    public static Site me() {
        return new Site();
    }

    /**
     * add a cookie with domain
     * @param name
     * @param value
     * @return this
     */
    public Site addCookie(String name, String value) {
        defaultCookies.put(name, value);
        return this;
    }

    /**
     * add a cookie with specific domain
     * @param domain
     * @param name
     * @param value
     * @return this
     */
    public Site addCookies(String domain, String name, String value) {
        if(!cookies.containsKey(domain)) {
            cookies.put(domain, new HashMap<>());
        }
        cookies.get(domain).put(name, value);
        return this;
    }

    /**
     * set user agent
     * @param userAgent
     * @return this
     */
    public Site setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * get cookies
     * @return defaultCookies
     */
    public Map<String, String> getCookies() {
        return defaultCookies;
    }

    /**
     * get cookies of all domain
     * @return cookies
     */
    public Map<String, Map<String, String>> getAllCookies() {
        return cookies;
    }

    /**
     * get user agent
     * @return useragent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * get domain
     * @return domain
     */
    public String getDomain() {
        return domain;
    }

    public Site setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Site setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public Site setTimeOut(int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    /**
     * Set acceptStatCode
     * When status code of http response is in this set, it will be processed.
     * {200} by default
     * @param acceptStatCode
     * @return
     */
    public Site setAcceptStatCode(Set<Integer> acceptStatCode) {
        this.acceptStatCode = acceptStatCode;
        return this;
    }

    public Set<Integer> getAcceptStatCode() {
        return acceptStatCode;
    }

    /**
     * set the inteval between the processing of two pages.
     * time unit is milliseconds.
     * @param sleepTime
     * @return
     */
    public Site setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }

    public int getSleepTime() {
        return sleepTime;
    }


    public int getRetryTimes() {
        return retryTimes;
    }

    /**
     * set retry times when download fail, 0 by default
     * @param retryTimes
     * @return this
     */
    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * put a http header for downloader.
     * use {@link #addCookie(String, String)} for cookie and {@link #setUserAgent(String)} for user-agent
     * @param key of http header, there are some keys constant in {@link HttpConstant.Header}
     * @param value of header
     * @return this
     */
    public Site addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    /**
     * when cycleRetryTime is more than 0, it will add back to scheduler and try download again.
     * @return cycleRetryTimes
     */
    public int getCycleRetryTimes() {
        return cycleRetryTimes;
    }

    /**
     * set cycleRetryTimes time when download fail, 0 by default.
     * @param cycleRetryTimes
     * @return this
     */
    public Site setCycleRetryTimes(int cycleRetryTimes) {
        this.cycleRetryTimes = cycleRetryTimes;
        return this;
    }


    public boolean isUseGzip() {
        return useGzip;
    }

    /**
     * whether use gzip, default is true, you can set it to false to disable gzip.
     * @param useGzip
     */
    public void setUseGzip(boolean useGzip) {
        this.useGzip = useGzip;
    }

    public boolean isDisableCookieManagement() {
        return disableCookieManagement;
    }

    /**
     *
     * @param disableCookieManagement
     * @return
     */
    public Site setDisableCookieManagement(boolean disableCookieManagement) {
        this.disableCookieManagement = disableCookieManagement;
        return this;
    }
}
