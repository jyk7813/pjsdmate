package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Requirement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requirement_no;
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
    private String q5_studio_dress;
    private String q5_studio_suit;
    private String q6_snap_photo;
    private String q6_snap_video;
    private String q6_snap_makeup;
    private String q6_snap_dress;
    private String q6_snap_suit;
    private String q6_snap_place;
    private String q7_estimate;

}
