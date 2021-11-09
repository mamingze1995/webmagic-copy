package com.mmz.webmagic.copy.constant;

/**
 * @Description: note
 * @Author: mamingze
 * @Date: 2021/11/1 22:09
 **/
public class HttpConstant {

    public static class Method {
        public static final String GET = "GET";

        public static final String HEAD = "HEAD";

        public static final String POST = "POST";

        public static final String PUT = "PUT";

        public static final String DELETE = "DELETE";

        public static final String TRACE = "TRACE";

        public static final String CONNECT = "CONNECT";

    }

    // todo abstract
    public static class StatusCode{
        public static final int CODE_200 = 200;

    }

    // todo abstract
    public static class Header {
        public static final String REFERER = "Referer";

        public static final String USER_AGENT = "User-Agent";
    }
}
