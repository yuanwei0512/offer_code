package com.hyw.java8.stream13;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/13 10:51
 * Description：TODO
 */
public class TrainJourney {

    private int price;
    private TrainJourney onward;

    public TrainJourney(int price, TrainJourney onward) {
        this.price = price;
        this.onward = onward;
    }




    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TrainJourney getOnward() {
        return onward;
    }

    public void setOnward(TrainJourney onward) {
        this.onward = onward;
    }
}
