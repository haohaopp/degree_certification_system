package com.common.entity;

/**
 * ClassName:Degrees
 * Description: 学位证书实体类
 */
public class Degrees {

    /**
     * 证书编号
     */
    private Integer degree_id;
    /**
     * 学生编号
     */
    private Integer student_id;
    /**
     * 机构编号
     */
    private Integer org_id;
    /**
     * 学位名称
     */
    private String degree_name;
    /**
     * 颁发日期
     */
    private String issue_date;
    /**
     * 证书状态
     */
    private String status;
    private Userinfo userUser;
    private Organizations orgUser;


    public Integer getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(Integer degree_id) {
        this.degree_id = degree_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public String getDegree_name() {
        return degree_name;
    }

    public void setDegree_name(String degree_name) {
        this.degree_name = degree_name;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Userinfo getUserUser() {
        return userUser;
    }

    public void setUserUser(Userinfo userUser) {
        this.userUser = userUser;
    }

    public Organizations getOrgUser() {
        return orgUser;
    }

    public void setOrgUser(Organizations orgUser) {
        this.orgUser = orgUser;
    }

    @Override
    public String toString() {
        return "Degrees{" +
                "degree_id=" + degree_id +
                ", student_id=" + student_id +
                ", org_id=" + org_id +
                ", degree_name='" + degree_name + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", status='" + status + '\'' +
                ", userUser=" + userUser +
                ", orgUser=" + orgUser +
                '}';
    }
}
