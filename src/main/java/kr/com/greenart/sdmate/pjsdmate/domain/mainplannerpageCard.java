package kr.com.greenart.sdmate.pjsdmate.domain;

import lombok.Getter;

public class mainplannerpageCard {
    private int price;
    private int memberPk;
    private String memberName;
    private String area;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getMemberPk() {
        return memberPk;
    }

    public void setMemberPk(int memberPk) {
        this.memberPk = memberPk;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "mainplannerpageCard{" +
                "price=" + price +
                ", memberPk=" + memberPk +
                ", memberName='" + memberName + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
