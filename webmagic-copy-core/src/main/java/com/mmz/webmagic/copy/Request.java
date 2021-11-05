package com.mmz.webmagic.copy;

import java.io.Serializable;

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



}
