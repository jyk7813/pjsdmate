package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Entity
public class Planner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plannerNo;
    @NotNull(message = "이름을 입력해주세요")
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하로 입력해주세요")
    @Pattern(regexp = "^[가-힣]*$", message = "이름은 한글만 입력해주세요")
    private String name;
    @NotNull(message = "생일을 입력해 주세요")
    private String identity_no;
    @NotNull(message = "사업자번호를 입력해주세요")
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{5}$", message = "올바른 사업자번호 형식을 입력해주세요")
    private String business_no;
    @NotNull(message = "아이디를 입력해주세요")
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하로 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 영문과 숫자만 입력해주세요")
    private String id;
    @NotNull(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영문과 숫자만 입력해주세요")
    private String pwd;
    @NotNull(message = "전화번호를 입력해주세요")
    @Pattern(regexp = "^(010|011)-\\d{4}-\\d{4}$", message = "올바른 전화번호 형식을 입력해주세요")

    private String phonenum;
    @NotNull(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$", message = "올바른 이메일 형식을 입력해주세요")
    private String email;
    @NotNull(message = "상호명을 입력해주세요")
    @Size(min = 2, max = 20, message = "상호명은 2자 이상 20자 이하로 입력해주세요")
    private String business_name;

    private int dealCnt;
    private double rating;
    private boolean active;
    @NotNull(message = "지역을 입력해주세요")
    @Size(min = 2, max = 20, message = "지역은 2자 이상 20자 이하로 입력해주세요")
    @Pattern(regexp = "^[가-힣]*$", message = "지역은 한글만 입력해주세요")
    private String region;
    private byte[] image;

    @Override
    public String toString() {
        return "Planner{" +
                "plannerNo=" + plannerNo +
                ", name='" + name + '\'' +
                ", identity_no='" + identity_no + '\'' +
                ", business_no='" + business_no + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", business_name='" + business_name + '\'' +
                ", dealCnt=" + dealCnt +
                ", rating=" + rating +
                ", active=" + active +
                ", region='" + region + '\'' +
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
