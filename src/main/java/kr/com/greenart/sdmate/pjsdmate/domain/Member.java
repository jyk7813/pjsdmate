package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_no;
    private String name;
    private String identity_no;
    private String id;
    private String pwd;
    private String phoneNum;
    private String email;
    private boolean active;
    private byte[] image;

}
