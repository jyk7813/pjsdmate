package kr.com.greenart.sdmate.pjsdmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specification_no;
    private int weddinghall;
    private int dress;
    private int parentsdress;
    private int photo;
    private int studio;
    private int snap;
    private int hirecost;
}
