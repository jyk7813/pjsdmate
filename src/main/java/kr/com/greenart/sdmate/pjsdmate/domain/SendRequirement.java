package kr.com.greenart.sdmate.pjsdmate.domain;

import java.util.Date;

public class SendRequirement {

    private Integer requirementNo;

    private String q1City;

    private String q1Gu;

    private String q1_guestno;

    private Date q1Date;

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

    private String q5_bride_cloth;

    private String q5_groom_cloth;

    private String q6_snap_photo;
    private String q6_snap_video;
    private String q6_snap_makeup;

    private String q6_snap_bride_cloth;
    private String q6_snap_groom_cloth;
    private String q6_snap_place;

    private String q7Estimate;

    public String getQ7Estimate() {
        return q7Estimate;
    }

    public void setQ7Estimate(String q7Estimate) {
        this.q7Estimate = q7Estimate;

    }
    public SendRequirement setting(SendRequirement sendRequirement, Requirement requirement){

        sendRequirement.setRequirementNo(requirement.getRequirementNo());
        String Q1_guestNo="";
        if(requirement.getQ1_guestno().equals("1")){
                Q1_guestNo= "50명 이하";
        }if(requirement.getQ1_guestno().equals("2")){
            Q1_guestNo="100명 이하";
        }if(requirement.getQ1_guestno().equals("3")){
            Q1_guestNo="150명 이하";
        }if(requirement.getQ1_guestno().equals("4")){
            Q1_guestNo="200 이상";
        }

        sendRequirement.setQ1_guestno(Q1_guestNo);

        sendRequirement.setQ1City(requirement.getQ1City());
        sendRequirement.setQ1Gu(requirement.getQ1Gu());
        sendRequirement.setQ1Date(requirement.getQ1Date());
        sendRequirement.setQ2_dress(requirement.getQ2_dress());
        sendRequirement.setQ2_suit(requirement.getQ2_suit());
        sendRequirement.setQ3_Fmom_hanbok(requirement.getQ3_Fmom_hanbok());
        sendRequirement.setQ3_Fdad_suit(requirement.getQ3_Fdad_suit());
        sendRequirement.setQ3_Mmom_hanbok(requirement.getQ3_Mmom_hanbok());
        sendRequirement.setQ3_Mdad_suit(requirement.getQ3_Mdad_suit());
        sendRequirement.setQ4_wedding_photo(requirement.getQ4_wedding_photo());
        sendRequirement.setQ4_wedding_video(requirement.getQ4_wedding_video());
        sendRequirement.setQ5_studio_photo(requirement.getQ5_studio_photo());
        sendRequirement.setQ5_studio_video(requirement.getQ5_studio_video());
        sendRequirement.setQ5_studio_makeup(requirement.getQ5_studio_makeup());
        String q5_bride_cloth = "";
        if(requirement.getQ5_studio_bride_dress()!= null){
            q5_bride_cloth="드레스";
        }if(requirement.getQ5_studio_bride_hanbok()!=null){
            q5_bride_cloth = q5_bride_cloth + " 한복";
        }if(requirement.getQ5_studio_bride_self() !=null){
            q5_bride_cloth = q5_bride_cloth + " 직접 준비 ";
        }
        sendRequirement.setQ5_bride_cloth(q5_bride_cloth);

        String q5_groom_cloth="";

        if(requirement.getQ5_studio_groom_suit() !=null){
            q5_groom_cloth = "정장";
        }if(requirement.getQ5_studio_groom_hanbok() !=null){
            q5_groom_cloth = q5_groom_cloth+" 한복";
        }if(requirement.getQ5_studio_groom_self() !=null){
            q5_groom_cloth = q5_groom_cloth+" 직접 준비";
        }
        sendRequirement.setQ5_groom_cloth(q5_groom_cloth);

        String q6_bride_cloth="";
        if(requirement.getQ6_snap_bride_dress()!=null){
            q6_bride_cloth ="드레스";
        }if(requirement.getQ6_snap_bride_hanbok()!=null){
            q6_bride_cloth=" 한복";
        }if(requirement.getQ6_snap_bride_self()!=null){
            q6_bride_cloth=" 직접준비";
        }
        sendRequirement.setQ6_snap_bride_cloth(q6_bride_cloth);

        String q6_groom_cloth="";
        if(requirement.getQ6_snap_groom_suit()!=null){
            q6_groom_cloth ="정장";
        }if(requirement.getQ6_snap_groom_hanbok()!=null){
            q6_groom_cloth=" 한복";
        }if(requirement.getQ6_snap_groom_self()!=null){
            q6_groom_cloth=" 직접준비";
        }
        sendRequirement.setQ6_snap_groom_cloth(q6_groom_cloth);

        sendRequirement.setQ6_snap_photo(requirement.getQ6_snap_photo());
        sendRequirement.setQ6_snap_video(requirement.getQ6_snap_video());
        sendRequirement.setQ6_snap_makeup(requirement.getQ6_snap_makeup());
        sendRequirement.setQ6_snap_place(requirement.getQ6_snap_place());

        if(requirement.getQ7Estimate()==500){
            sendRequirement.setQ7Estimate("~500만원");
        }else if(requirement.getQ7Estimate()==1000){
            sendRequirement.setQ7Estimate("500만원~1000만원");
        }else if(requirement.getQ7Estimate()==1500){
            sendRequirement.setQ7Estimate("1000만원~1500만원");
        }else if(requirement.getQ7Estimate()==2000){
            sendRequirement.setQ7Estimate("1500만원~2000원");
        }else if(requirement.getQ7Estimate()==9999){
            sendRequirement.setQ7Estimate("상관없음");
        }
        return sendRequirement;
    }

    public Integer getRequirementNo() {
        return requirementNo;
    }

    public void setRequirementNo(Integer requirementNo) {
        this.requirementNo = requirementNo;
    }

    public String getQ1City() {
        return q1City;
    }

    public void setQ1City(String q1City) {
        this.q1City = q1City;
    }

    public String getQ1Gu() {
        return q1Gu;
    }

    public void setQ1Gu(String q1Gu) {
        this.q1Gu = q1Gu;
    }

    public String getQ1_guestno() {
        return q1_guestno;
    }

    public void setQ1_guestno(String q1_guestno) {
        this.q1_guestno = q1_guestno;
    }

    public Date getQ1Date() {
        return q1Date;
    }

    public void setQ1Date(Date q1Date) {
        this.q1Date = q1Date;
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

    public String getQ5_bride_cloth() {
        return q5_bride_cloth;
    }

    public void setQ5_bride_cloth(String q5_bride_cloth) {
        this.q5_bride_cloth = q5_bride_cloth;
    }

    public String getQ5_groom_cloth() {
        return q5_groom_cloth;
    }

    public void setQ5_groom_cloth(String q5_groom_cloth) {
        this.q5_groom_cloth = q5_groom_cloth;
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

    public String getQ6_snap_bride_cloth() {
        return q6_snap_bride_cloth;
    }

    public void setQ6_snap_bride_cloth(String q6_snap_bride_cloth) {
        this.q6_snap_bride_cloth = q6_snap_bride_cloth;
    }

    public String getQ6_snap_groom_cloth() {
        return q6_snap_groom_cloth;
    }

    public void setQ6_snap_groom_cloth(String q6_snap_groom_cloth) {
        this.q6_snap_groom_cloth = q6_snap_groom_cloth;
    }

    public String getQ6_snap_place() {
        return q6_snap_place;
    }

    public void setQ6_snap_place(String q6_snap_place) {
        this.q6_snap_place = q6_snap_place;
    }
}
