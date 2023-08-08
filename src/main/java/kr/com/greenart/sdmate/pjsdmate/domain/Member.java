package kr.com.greenart.sdmate.pjsdmate.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Member {
    @Id
   // @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;
    private String name;
    private String identity_no;
    private String id;
    private String pwd;

    private String phonenum;

    private String email;
    private boolean active;
    private byte[] image;

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", name='" + name + '\'' +
                ", identity_no='" + identity_no + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
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
