package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

public class mainpageCard {
    private String sum;
    private int plannerPk;
    private double rating;
    private int reviewCnt;
    private int dealCnt;
    private String plannerImg;
    private String businessName;

    private int specificationNo;

    @Override
    public String toString() {
        return "mainpageCard{" +
                "sum=" + sum +
                ", plannerPk=" + plannerPk +
                ", rating=" + rating +
                ", reviewCnt=" + reviewCnt +
                ", dealCnt=" + dealCnt +
                ", businessName='" + businessName + '\'' +
                ", specificationNo=" + specificationNo +
                '}';
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public int getPlannerPk() {
        return plannerPk;
    }

    public void setPlannerPk(int plannerPk) {
        this.plannerPk = plannerPk;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
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

    public String getPlannerImg() {
        return plannerImg;
    }

    public void setPlannerImg(String plannerImg) {
        this.plannerImg = plannerImg;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getSpecificationNo() {
        return specificationNo;
    }

    public void setSpecificationNo(int specificationNo) {
        this.specificationNo = specificationNo;
    }
}
