package kr.com.greenart.sdmate.pjsdmate.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Member {
    @Getter
    @Id
   // @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;
    @Getter
    private String name;
    @Getter
    private String identity_no;
    @Getter
    private String id;
    @Getter
    private String pwd;

    @Getter
    private String phonenum;

    @Getter
    private String email;
    @Getter
    private boolean active;
    private byte[] image;

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", name='" + name + '\'' +
                ", identity_no='" + identity_no + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setPhoneNum(String phoneNum) {
        this.phonenum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
