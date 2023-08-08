package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Planner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plannerNo;
    private String name;
    private String identityNo;
    private String businessNo;
    private String id;
    private String pwd;
    private String phonenum;
    private String email;
    private String businessName;
    private int dealCnt;
    private double rating;
    private boolean active;
    private byte[] image;

    @Override
    public String toString() {
        return "Planner{" +
                "plannerNo=" + plannerNo +
                ", name='" + name + '\'' +
                ", identityNo='" + identityNo + '\'' +
                ", bussinessNo='" + businessNo + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", bussinessName='" + businessName + '\'' +
                ", dealCnt=" + dealCnt +
                ", rating=" + rating +
                ", active=" + active +
                '}';
    }

    public Integer getPlannerNo() {
        return plannerNo;
    }

    public void setPlannerNo(Integer plannerNo) {
        this.plannerNo = plannerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getDealCnt() {
        return dealCnt;
    }

    public void setDealCnt(int dealCnt) {
        this.dealCnt = dealCnt;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
