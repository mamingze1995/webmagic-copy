package com.mmz.webmagic.copy.pipeline;

import com.mmz.webmagic.copy.ResultItems;
import com.mmz.webmagic.copy.Task;

/**
 * Pipeline is the persistent and offline process part of crawler.
 * The interface can be implemented to customize ways of persistent.
 * @auther MaMingze
 * @date 2021/11/11 12:43 上午
 */
public interface Pipeline {

    public void process(ResultItems resultItems, Task task);
}
