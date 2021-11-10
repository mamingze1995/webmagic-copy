package com.mmz.webmagic.copy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Object contains extract results.
 * It is contained in Page and will processed in pipeline.
 *
 * @auther MaMingze
 * @date 2021/11/11 12:46 上午
 */
public class ResultItems {

    private Map<String, Object> fileds = new LinkedHashMap<>();

    private Request request;

    private boolean skip;

    public <T> T getFileds(String key) {
        Object o = fileds.get(key);
        return o == null ? null : (T) o;
    }

    public void setFileds(Map<String, Object> fileds) {
        this.fileds = fileds;
    }
}
