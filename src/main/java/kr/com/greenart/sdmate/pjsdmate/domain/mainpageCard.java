package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

public class mainpageCard {
    private int sum;
    private int plannerPk;
    private long rating;
    private int reviewCnt;
    private int dealCnt;
    private byte[] plannerImg;
    private String businessName;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getPlannerPk() {
        return plannerPk;
    }

    public void setPlannerPk(int plannerPk) {
        this.plannerPk = plannerPk;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public int getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(int reviewCnt) {
        this.reviewCnt = reviewCnt;
    }

    public int getDealCnt() {
        return dealCnt;
    }

    public void setDealCnt(int dealCnt) {
        this.dealCnt = dealCnt;
    }

    public byte[] getPlannerImg() {
        return plannerImg;
    }

    public void setPlannerImg(byte[] plannerImg) {
        this.plannerImg = plannerImg;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "mainpageCard{" +
                "sum=" + sum +
                ", plannerPk=" + plannerPk +
                ", rating=" + rating +
                ", reviewCnt=" + reviewCnt +
                ", dealCnt=" + dealCnt +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
