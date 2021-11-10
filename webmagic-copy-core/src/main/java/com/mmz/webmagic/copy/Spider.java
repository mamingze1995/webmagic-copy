package com.mmz.webmagic.copy;

import com.mmz.webmagic.copy.downloader.Downloader;

/**
 * @Description: Spider
 * @Author: mamingze
 * @Date: 2021/10/25 22:15
 **/
public class Spider implements Runnable, Task{

    protected Downloader downloader;

    @Override
    public String getUUID() {
        return null;
    }

    @Override
    public Site getSite() {
        return null;
    }

    @Override
    public void run() {

    }
}
