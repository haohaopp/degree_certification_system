package com.common.entity;

/**
* ClassName:User_institution_bindings
* Description: 学生关系实体类
*/
public class User_institution_bindings {

    /**
    * 信息编号
    */
        private Integer binding_id;
    /**
    * 学生编号
    */
        private Integer student_id;
    /**
    * 机构编号
    */
        private Integer org_id;
    /**
    * 绑定时间
    */
        private String bind_date;


        public Integer getBinding_id() {
        return binding_id;
        }

        public void setBinding_id(Integer binding_id) {
        this.binding_id = binding_id;
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

        public String getBind_date() {
        return bind_date;
        }

        public void setBind_date(String bind_date) {
        this.bind_date = bind_date;
        }


}