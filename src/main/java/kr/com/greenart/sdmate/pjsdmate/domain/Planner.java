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
    private String identity_no;
    private String business_no;
    private String id;
    private String pwd;
    private String phonenum;
    private String email;
    private String business_name;
    private int dealCnt;
    private double rating;
    private boolean active;
    private String region;
    private byte[] image;

    @Override
    public String toString() {
        return "Planner{" +
                "image=" + Arrays.toString(image) +
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

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public String getBusiness_no() {
        return business_no;
    }

    public void setBusiness_no(String bussiness_no) {
        this.business_no = bussiness_no;
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

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String bussiness_name) {
        this.business_name = bussiness_name;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
