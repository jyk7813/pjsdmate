package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planner_no;
    private String name;
    private String identity_no;
    private String bussiness_no;
    private String id;
    private String pwd;
    private String phoneNum;
    private String email;
    private String bussiness_name;
    private int deal_cnt;
    private double rating;
    private boolean active;
    private byte[] image;

}
