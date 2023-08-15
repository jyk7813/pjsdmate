package kr.com.greenart.sdmate.pjsdmate.domain;

public class MySpecification {
    private int requirementPk;

    private String requirementPrice;

    private String memberImg;
    private String memberName;

    private String city;
    private String gu;

    private int specificationNo;
    private int specificationPrice;

    @Override
    public String toString() {
        return "MySpecification{" +
                "requirementPk=" + requirementPk +
                ", requirementPrice='" + requirementPrice + '\'' +
                ", memberImg='" + memberImg + '\'' +
                ", memberName='" + memberName + '\'' +
                ", city='" + city + '\'' +
                ", gu='" + gu + '\'' +
                ", specificationNo=" + specificationNo +
                ", specificationPrice=" + specificationPrice +
                '}';
    }

    public int getRequirementPk() {
        return requirementPk;
    }

    public void setRequirementPk(int requirementPk) {
        this.requirementPk = requirementPk;
    }

    public String getRequirementPrice() {
        return requirementPrice;
    }

    public void setRequirementPrice(String requirementPrice) {
        this.requirementPrice = requirementPrice;
    }

    public String getMemberImg() {
        return memberImg;
    }

    public void setMemberImg(String memberImg) {
        this.memberImg = memberImg;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public int getSpecificationNo() {
        return specificationNo;
    }

    public void setSpecificationNo(int specificationNo) {
        this.specificationNo = specificationNo;
    }

    public int getSpecificationPrice() {
        return specificationPrice;
    }

    public void setSpecificationPrice(int specificationPrice) {
        this.specificationPrice = specificationPrice;
    }
}
