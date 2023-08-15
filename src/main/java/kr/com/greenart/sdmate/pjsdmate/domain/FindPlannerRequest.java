package kr.com.greenart.sdmate.pjsdmate.domain;

public class FindPlannerRequest {

    private int plannerNo;
    private String id;
    private String name;
    private String identity_no;
    private String email;
    private String phonenum;
    private String pwd;
    private String requirementPk;

    public int getPlannerNo() {
        return plannerNo;
    }

    public void setPlannerNo(int plannerNo) {
        this.plannerNo = plannerNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRequirementPk() {
        return requirementPk;
    }

    public void setRequirementPk(String requirementPk) {
        this.requirementPk = requirementPk;
    }
}
