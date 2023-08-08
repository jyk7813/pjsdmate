package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewNo;

    private int planner_no;
    private int member_no;
    private String context;
    private byte[] image;

    @Override
    public String toString() {
        return "Review{" +
                "reviewNo=" + reviewNo +
                ", planner_no=" + planner_no +
                ", member_no=" + member_no +
                ", context='" + context + '\'' +
                '}';
    }

    public Integer getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getPlanner_no() {
        return planner_no;
    }

    public void setPlanner_no(int planner_no) {
        this.planner_no = planner_no;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
