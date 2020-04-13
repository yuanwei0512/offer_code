package com.hyw.newstudy.station;

import java.util.concurrent.CountDownLatch;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 20:51
 * Description：TODO
 */
public class BeijinStationCenter extends DangerCenter {


    public BeijinStationCenter(String station) {
        super(station, false);
    }

    @Override
    public void checkout() {
        System.out.println("正在检查 [" + this.station + "]...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("检查 [" + this.station + "] 完毕，可以发车~");
    }


}
