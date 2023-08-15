package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Mchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String content;

    @Column(name="member_no")
    private int memberNo;
    @Column(name="planner_no")
    private int plannerNo;
    private Timestamp datetime;
    private int view;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mchat mchat = (Mchat) o;
        return memberNo == mchat.memberNo && plannerNo == mchat.plannerNo && view == mchat.view && Objects.equals(no, mchat.no) && Objects.equals(content, mchat.content) && Objects.equals(datetime, mchat.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, content, memberNo, plannerNo, datetime, view);
    }

    @Override
    public String toString() {
        return "mchat{" +
                "no=" + no +
                ", content='" + content + '\'' +
                ", memberNo=" + memberNo +
                ", plannerNo=" + plannerNo +
                ", datetime=" + datetime +
                ", view=" + view +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getPlannerNo() {
        return plannerNo;
    }

    public void setPlannerNo(int plannerNo) {
        this.plannerNo = plannerNo;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
