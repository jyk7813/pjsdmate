package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specificationNo;
    private int weddinghall;
    private int dress;
    private int parentsdress;
    private int photo;
    private int studio;
    private int snap;
    private int hirecost;
    private int state;

    private int requirement_no;
    public int calculateSumExceptSpecNoAndState() {
        return weddinghall + dress + parentsdress + photo + studio + snap + hirecost;
    }

    public int getRequirement_no() {
        return requirement_no;
    }

    public void setRequirement_no(int requirement_no) {
        this.requirement_no = requirement_no;
    }

    public int parseInt(String s){
        return Integer.parseInt(s);
    }

    @Override
    public String  toString() {
        return "Specification{" +
                "specificationNo=" + specificationNo +
                ", weddinghall=" + weddinghall +
                ", dress=" + dress +
                ", parentsdress=" + parentsdress +
                ", photo=" + photo +
                ", studio=" + studio +
                ", snap=" + snap +
                ", hirecost=" + hirecost +
                ", state=" + state +
                ", requirement_no=" + requirement_no +
                '}';
    }

    public Integer getSpecificationNo() {
        return specificationNo;
    }

    public void setSpecificationNo(Integer specificationNo) {
        this.specificationNo = specificationNo;
    }

    public int getWeddinghall() {
        return weddinghall;
    }

    public void setWeddinghall(int weddinghall) {
        this.weddinghall = weddinghall;
    }

    public int getDress() {
        return dress;
    }

    public void setDress(int dress) {
        this.dress = dress;
    }

    public int getParentsdress() {
        return parentsdress;
    }

    public void setParentsdress(int parentsdress) {
        this.parentsdress = parentsdress;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getStudio() {
        return studio;
    }

    public void setStudio(int studio) {
        this.studio = studio;
    }

    public int getSnap() {
        return snap;
    }

    public void setSnap(int snap) {
        this.snap = snap;
    }

    public int getHirecost() {
        return hirecost;
    }

    public void setHirecost(int hirecost) {
        this.hirecost = hirecost;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
