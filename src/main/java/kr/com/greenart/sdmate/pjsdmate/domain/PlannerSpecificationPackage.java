package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "planner_specification")
public class PlannerSpecificationPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private int plannerNo;
    private int specificationNo;
    private int memberNo;
    private Date datetime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannerSpecificationPackage that = (PlannerSpecificationPackage) o;
        return plannerNo == that.plannerNo && specificationNo == that.specificationNo && memberNo == that.memberNo && Objects.equals(no, that.no) && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, plannerNo, specificationNo, memberNo, datetime);
    }

    @Override
    public String toString() {
        return "PlannerSpecificationPackage{" +
                "no=" + no +
                ", plannerNo=" + plannerNo +
                ", specificationNo=" + specificationNo +
                ", memberNo=" + memberNo +
                ", datetime=" + datetime +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public int getPlannerNo() {
        return plannerNo;
    }

    public void setPlannerNo(int plannerNo) {
        this.plannerNo = plannerNo;
    }

    public int getSpecificationNo() {
        return specificationNo;
    }

    public void setSpecificationNo(int specificationNo) {
        this.specificationNo = specificationNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
