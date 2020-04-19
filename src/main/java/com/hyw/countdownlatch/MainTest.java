package com.hyw.countdownlatch;

import com.hyw.countdownlatch.station.BeijinStationCenter;
import com.hyw.countdownlatch.station.TianjtationCenter;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 21:20
 * Description：TODO
 */
public class MainTest {

    public static void main(String[] args) {

        BeijinStationCenter beijinStationCenter = new BeijinStationCenter("北京验证");
        TianjtationCenter tianjtationCenter = new TianjtationCenter("天津验证");

        CheckStartUp checkStartUp = new CheckStartUp(Arrays.asList(beijinStationCenter, tianjtationCenter));
        boolean isFine = false;
        try {
            isFine = checkStartUp.checkStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(isFine);
    }

}
