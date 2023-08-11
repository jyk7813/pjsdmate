package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.*;

@Entity
public class MemberRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    private Integer memberNo;

    @Column
    private Integer requirementNo;

    @Override
    public String toString() {
        return "MemberRequirement{" +
                "no=" + no +
                ", memberNo=" + memberNo +
                ", requiremnetNo=" + requirementNo +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getRequiremnetNo() {
        return requirementNo;
    }

    public void setRequiremnetNo(Integer requiremnetNo) {
        this.requirementNo = requiremnetNo;
    }
}
