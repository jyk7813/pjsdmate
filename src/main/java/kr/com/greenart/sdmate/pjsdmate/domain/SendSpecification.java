package kr.com.greenart.sdmate.pjsdmate.domain;

import java.text.DecimalFormat;

public class SendSpecification {
    private Integer specificationNo;
    private String weddinghall;
    private String dress;
    private String parentsdress;
    private String photo;
    private String studio;
    private String snap;
    private String hirecost;
    private String state;
    private String sum;

    public String format(int value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(value) + "원";
    }
    public SendSpecification setting(SendSpecification sendSpecification, Specification specification) {
        sendSpecification.setSpecificationNo(specification.getSpecificationNo());
        sendSpecification.setWeddinghall(format(specification.getWeddinghall()));
        sendSpecification.setDress(format(specification.getDress()));
        sendSpecification.setParentsdress(format(specification.getParentsdress()));
        sendSpecification.setPhoto(format(specification.getPhoto()));
        sendSpecification.setStudio(format(specification.getStudio()));
        sendSpecification.setSnap(format(specification.getSnap()));
        sendSpecification.setHirecost(format(specification.getHirecost()));
        sendSpecification.setState(String.valueOf(specification.getState()));
        sendSpecification.setSum(format(specification.calculateSumExceptSpecNoAndState()));
        return sendSpecification;
    }

    public Integer getSpecificationNo() {
        return specificationNo;
    }

    public void setSpecificationNo(Integer specificationNo) {
        this.specificationNo = specificationNo;
    }

    public String getWeddinghall() {
        return weddinghall;
    }

    public void setWeddinghall(String weddinghall) {
        this.weddinghall = weddinghall;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public String getParentsdress() {
        return parentsdress;
    }

    public void setParentsdress(String parentsdress) {
        this.parentsdress = parentsdress;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getSnap() {
        return snap;
    }

    public void setSnap(String snap) {
        this.snap = snap;
    }

    public String getHirecost() {
        return hirecost;
    }

    public void setHirecost(String hirecost) {
        this.hirecost = hirecost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
