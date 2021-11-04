package com.mmz.webmagic.copy;

/**
 * @Description: note
 * @Author: mamingze
 * @Date: 2021/10/25 22:19
 **/
public interface Task {

    /**
     * unique id for a task.
     *
     * @return uuid
     */
    public String getUUID();

    /**
     * site of a task
     * @return site
     */
    public Site getSite();
}
