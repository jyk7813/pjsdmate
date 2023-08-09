package kr.com.greenart.sdmate.pjsdmate.domain;

import lombok.Getter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Member {
    @Id
    // @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;
    @NotNull(message = "이름을 입력해주세요")
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하로 입력해주세요")
    @Pattern(regexp = "^[가-힣]*$", message = "이름은 한글만 입력해주세요")
    private String name;
    @NotNull(message = "생일을 입력해 주세요")
    private String identity_no;
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
    @Email(message = "이메일 형식에 맞게 입력해주세요")
    private String email;
    private boolean active;
    private byte[] image;

    @Column(name="requirement_pk")
    private Integer requirementPk;

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
                ", requirementPk=" + requirementPk +
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

    public Integer getRequirementPk() {
        return requirementPk;
    }

    public void setRequirementPk(Integer requirementPk) {
        this.requirementPk = requirementPk;
    }
}
