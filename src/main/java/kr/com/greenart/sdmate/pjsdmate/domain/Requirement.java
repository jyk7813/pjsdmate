package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Requirement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requirementNo;
    private String q1_city;
    private String q1_gu;
    private String q1_guestno;
    private Date q1_date;
    private String q2_dress;
    private String q2_suit;
    private String q3_Fmom_hanbok;
    private String q3_Fdad_suit;
    private String q3_Mmom_hanbok;
    private String q3_Mdad_suit;
    private String q4_wedding_photo;
    private String q4_wedding_video;
    private String q5_studio_photo;
    private String q5_studio_video;
    private String q5_studio_makeup;
    private boolean q5_studio_bride_dress;
    private boolean q5_studio_bride_hanbok;
    private boolean q5_studio_bride_suit;
    private boolean q5_studio_bride_self;
    private boolean q5_studio_groom_suit;
    private boolean q5_studio_groom_hanbok;
    private boolean q5_studio_groom_self;
    private String q6_snap_photo;
    private String q6_snap_video;
    private String q6_snap_makeup;
    private String q6_snap_bride_dress;
    private String q6_snap_bride_hanbok;
    private String q6_snap_bride_suit;
    private String q6_snap_bride_self;
    private String q6_snap_groom_suit;
    private String q6_snap_groom_hanbok;
    private String q6_snap_groom_self;
    private String q6_snap_place;
    private int q7_estimate;

    @Override
    public String toString() {
        return "Requirement{" +
                "requirementNo=" + requirementNo +
                ", q1_city='" + q1_city + '\'' +
                ", q1_gu='" + q1_gu + '\'' +
                ", q1_guestno='" + q1_guestno + '\'' +
                ", q1_date=" + q1_date +
                ", q2_dress='" + q2_dress + '\'' +
                ", q2_suit='" + q2_suit + '\'' +
                ", q3_Fmom_hanbok='" + q3_Fmom_hanbok + '\'' +
                ", q3_Fdad_suit='" + q3_Fdad_suit + '\'' +
                ", q3_Mmom_hanbok='" + q3_Mmom_hanbok + '\'' +
                ", q3_Mdad_suit='" + q3_Mdad_suit + '\'' +
                ", q4_wedding_photo='" + q4_wedding_photo + '\'' +
                ", q4_wedding_video='" + q4_wedding_video + '\'' +
                ", q5_studio_photo='" + q5_studio_photo + '\'' +
                ", q5_studio_video='" + q5_studio_video + '\'' +
                ", q5_studio_makeup='" + q5_studio_makeup + '\'' +
                ", q5_studio_bride_dress=" + q5_studio_bride_dress +
                ", q5_studio_bride_hanbok=" + q5_studio_bride_hanbok +
                ", q5_studio_bride_suit=" + q5_studio_bride_suit +
                ", q5_studio_bride_self=" + q5_studio_bride_self +
                ", q5_studio_groom_suit=" + q5_studio_groom_suit +
                ", q5_studio_groom_hanbok=" + q5_studio_groom_hanbok +
                ", q5_studio_groom_self=" + q5_studio_groom_self +
                ", q6_snap_photo='" + q6_snap_photo + '\'' +
                ", q6_snap_video='" + q6_snap_video + '\'' +
                ", q6_snap_makeup='" + q6_snap_makeup + '\'' +
                ", q6_snap_bride_dress='" + q6_snap_bride_dress + '\'' +
                ", q6_snap_bride_hanbok='" + q6_snap_bride_hanbok + '\'' +
                ", q6_snap_bride_suit='" + q6_snap_bride_suit + '\'' +
                ", q6_snap_bride_self='" + q6_snap_bride_self + '\'' +
                ", q6_snap_groom_suit='" + q6_snap_groom_suit + '\'' +
                ", q6_snap_groom_hanbok='" + q6_snap_groom_hanbok + '\'' +
                ", q6_snap_groom_self='" + q6_snap_groom_self + '\'' +
                ", q6_snap_place='" + q6_snap_place + '\'' +
                ", q7_estimate=" + q7_estimate +
                '}';
    }

    public Integer getRequirementNo() {
        return requirementNo;
    }

    public void setRequirementNo(Integer requirementNo) {
        this.requirementNo = requirementNo;
    }

    public String getQ1_city() {
        return q1_city;
    }

    public void setQ1_city(String q1_city) {
        this.q1_city = q1_city;
    }

    public String getQ1_gu() {
        return q1_gu;
    }

    public void setQ1_gu(String q1_gu) {
        this.q1_gu = q1_gu;
    }

    public String getQ1_guestno() {
        return q1_guestno;
    }

    public void setQ1_guestno(String q1_guestno) {
        this.q1_guestno = q1_guestno;
    }

    public Date getQ1_date() {
        return q1_date;
    }

    public void setQ1_date(Date q1_date) {
        this.q1_date = q1_date;
    }

    public String getQ2_dress() {
        return q2_dress;
    }

    public void setQ2_dress(String q2_dress) {
        this.q2_dress = q2_dress;
    }

    public String getQ2_suit() {
        return q2_suit;
    }

    public void setQ2_suit(String q2_suit) {
        this.q2_suit = q2_suit;
    }

    public String getQ3_Fmom_hanbok() {
        return q3_Fmom_hanbok;
    }

    public void setQ3_Fmom_hanbok(String q3_Fmom_hanbok) {
        this.q3_Fmom_hanbok = q3_Fmom_hanbok;
    }

    public String getQ3_Fdad_suit() {
        return q3_Fdad_suit;
    }

    public void setQ3_Fdad_suit(String q3_Fdad_suit) {
        this.q3_Fdad_suit = q3_Fdad_suit;
    }

    public String getQ3_Mmom_hanbok() {
        return q3_Mmom_hanbok;
    }

    public void setQ3_Mmom_hanbok(String q3_Mmom_hanbok) {
        this.q3_Mmom_hanbok = q3_Mmom_hanbok;
    }

    public String getQ3_Mdad_suit() {
        return q3_Mdad_suit;
    }

    public void setQ3_Mdad_suit(String q3_Mdad_suit) {
        this.q3_Mdad_suit = q3_Mdad_suit;
    }

    public String getQ4_wedding_photo() {
        return q4_wedding_photo;
    }

    public void setQ4_wedding_photo(String q4_wedding_photo) {
        this.q4_wedding_photo = q4_wedding_photo;
    }

    public String getQ4_wedding_video() {
        return q4_wedding_video;
    }

    public void setQ4_wedding_video(String q4_wedding_video) {
        this.q4_wedding_video = q4_wedding_video;
    }

    public String getQ5_studio_photo() {
        return q5_studio_photo;
    }

    public void setQ5_studio_photo(String q5_studio_photo) {
        this.q5_studio_photo = q5_studio_photo;
    }

    public String getQ5_studio_video() {
        return q5_studio_video;
    }

    public void setQ5_studio_video(String q5_studio_video) {
        this.q5_studio_video = q5_studio_video;
    }

    public String getQ5_studio_makeup() {
        return q5_studio_makeup;
    }

    public void setQ5_studio_makeup(String q5_studio_makeup) {
        this.q5_studio_makeup = q5_studio_makeup;
    }

    public boolean isQ5_studio_bride_dress() {
        return q5_studio_bride_dress;
    }

    public void setQ5_studio_bride_dress(boolean q5_studio_bride_dress) {
        this.q5_studio_bride_dress = q5_studio_bride_dress;
    }

    public boolean isQ5_studio_bride_hanbok() {
        return q5_studio_bride_hanbok;
    }

    public void setQ5_studio_bride_hanbok(boolean q5_studio_bride_hanbok) {
        this.q5_studio_bride_hanbok = q5_studio_bride_hanbok;
    }

    public boolean isQ5_studio_bride_suit() {
        return q5_studio_bride_suit;
    }

    public void setQ5_studio_bride_suit(boolean q5_studio_bride_suit) {
        this.q5_studio_bride_suit = q5_studio_bride_suit;
    }

    public boolean isQ5_studio_bride_self() {
        return q5_studio_bride_self;
    }

    public void setQ5_studio_bride_self(boolean q5_studio_bride_self) {
        this.q5_studio_bride_self = q5_studio_bride_self;
    }

    public boolean isQ5_studio_groom_suit() {
        return q5_studio_groom_suit;
    }

    public void setQ5_studio_groom_suit(boolean q5_studio_groom_suit) {
        this.q5_studio_groom_suit = q5_studio_groom_suit;
    }

    public boolean isQ5_studio_groom_hanbok() {
        return q5_studio_groom_hanbok;
    }

    public void setQ5_studio_groom_hanbok(boolean q5_studio_groom_hanbok) {
        this.q5_studio_groom_hanbok = q5_studio_groom_hanbok;
    }

    public boolean isQ5_studio_groom_self() {
        return q5_studio_groom_self;
    }

    public void setQ5_studio_groom_self(boolean q5_studio_groom_self) {
        this.q5_studio_groom_self = q5_studio_groom_self;
    }

    public String getQ6_snap_photo() {
        return q6_snap_photo;
    }

    public void setQ6_snap_photo(String q6_snap_photo) {
        this.q6_snap_photo = q6_snap_photo;
    }

    public String getQ6_snap_video() {
        return q6_snap_video;
    }

    public void setQ6_snap_video(String q6_snap_video) {
        this.q6_snap_video = q6_snap_video;
    }

    public String getQ6_snap_makeup() {
        return q6_snap_makeup;
    }

    public void setQ6_snap_makeup(String q6_snap_makeup) {
        this.q6_snap_makeup = q6_snap_makeup;
    }

    public String getQ6_snap_bride_dress() {
        return q6_snap_bride_dress;
    }

    public void setQ6_snap_bride_dress(String q6_snap_bride_dress) {
        this.q6_snap_bride_dress = q6_snap_bride_dress;
    }

    public String getQ6_snap_bride_hanbok() {
        return q6_snap_bride_hanbok;
    }

    public void setQ6_snap_bride_hanbok(String q6_snap_bride_hanbok) {
        this.q6_snap_bride_hanbok = q6_snap_bride_hanbok;
    }

    public String getQ6_snap_bride_suit() {
        return q6_snap_bride_suit;
    }

    public void setQ6_snap_bride_suit(String q6_snap_bride_suit) {
        this.q6_snap_bride_suit = q6_snap_bride_suit;
    }

    public String getQ6_snap_bride_self() {
        return q6_snap_bride_self;
    }

    public void setQ6_snap_bride_self(String q6_snap_bride_self) {
        this.q6_snap_bride_self = q6_snap_bride_self;
    }

    public String getQ6_snap_groom_suit() {
        return q6_snap_groom_suit;
    }

    public void setQ6_snap_groom_suit(String q6_snap_groom_suit) {
        this.q6_snap_groom_suit = q6_snap_groom_suit;
    }

    public String getQ6_snap_groom_hanbok() {
        return q6_snap_groom_hanbok;
    }

    public void setQ6_snap_groom_hanbok(String q6_snap_groom_hanbok) {
        this.q6_snap_groom_hanbok = q6_snap_groom_hanbok;
    }

    public String getQ6_snap_groom_self() {
        return q6_snap_groom_self;
    }

    public void setQ6_snap_groom_self(String q6_snap_groom_self) {
        this.q6_snap_groom_self = q6_snap_groom_self;
    }

    public String getQ6_snap_place() {
        return q6_snap_place;
    }

    public void setQ6_snap_place(String q6_snap_place) {
        this.q6_snap_place = q6_snap_place;
    }

    public int getQ7_estimate() {
        return q7_estimate;
    }

    public void setQ7_estimate(int q7_estimate) {
        this.q7_estimate = q7_estimate;
    }
}
