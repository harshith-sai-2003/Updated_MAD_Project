package com.example.onboarding;

public class ModelClass {
    private int cardview;
    private String tv1,tv2,tv3,divider;

    public ModelClass(int cardview, String tv1, String tv2, String tv3, String divider) {
        this.cardview = cardview;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.divider = divider;
    }

    public int getCardview() {
        return cardview;
    }

    public void setCardview(int cardview) {
        this.cardview = cardview;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }
}

