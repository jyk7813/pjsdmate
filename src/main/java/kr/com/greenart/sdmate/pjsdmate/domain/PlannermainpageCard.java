package kr.com.greenart.sdmate.pjsdmate.domain;

import java.util.Objects;

public class PlannermainpageCard {
    private int memberPk;
    private String memberName;

    private String memberImg;

    private int requirementPk;
    private int estimate;

    private String city;

    private String gu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannermainpageCard that = (PlannermainpageCard) o;
        return memberPk == that.memberPk && requirementPk == that.requirementPk && estimate == that.estimate && Objects.equals(memberName, that.memberName) && Objects.equals(memberImg, that.memberImg) && Objects.equals(city, that.city) && Objects.equals(gu, that.gu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberPk, memberName, memberImg, requirementPk, estimate, city, gu);
    }

    @Override
    public String toString() {
        return "PlannermainpageCard{" +
                "memberPk=" + memberPk +
                ", memberName='" + memberName + '\'' +
                ", requirementPk=" + requirementPk +
                ", estimate=" + estimate +
                ", city='" + city + '\'' +
                ", gu='" + gu + '\'' +
                '}';
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

    public String getMemberImg() {
        return memberImg;
    }

    public void setMemberImg(String memberImg) {
        this.memberImg = memberImg;
    }

    public int getRequirementPk() {
        return requirementPk;
    }

    public void setRequirementPk(int requirementPk) {
        this.requirementPk = requirementPk;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }
}
