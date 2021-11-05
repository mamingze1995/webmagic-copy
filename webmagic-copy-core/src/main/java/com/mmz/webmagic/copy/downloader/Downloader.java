package com.mmz.webmagic.copy.downloader;

import com.mmz.webmagic.copy.Page;
import com.mmz.webmagic.copy.Request;
import com.mmz.webmagic.copy.Task;

/**
 * @Description: note
 * @Author: mamingze
 * @Date: 2021/11/5 12:09
 **/
public interface Downloader {

    /**
     * Downloads web pages and store in Page object.
     * @param request
     * @param task
     * @return page
     */
    public Page download(Request request, Task task);

    /**
     * Tell the downloader how many threads the spider used.
     * @param threadNum number of threads
     */
    public void setThread(int threadNum);
}
