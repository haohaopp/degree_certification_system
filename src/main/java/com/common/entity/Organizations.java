package com.common.entity;

/**
* ClassName:Organizations
* Description: 机构企业实体类
*/
public class Organizations {

    /**
    * 机构编号
    */
        private Integer org_id;
    /**
    * 机构名称
    */
        private String org_name;
    /**
    * 机构类型
    */
        private String org_type;
    /**
    * 联系邮箱
    */
        private String contact_email;
    /**
    * 联系电话
    */
        private String contact_phone;


        public Integer getOrg_id() {
        return org_id;
        }

        public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
        }

        public String getOrg_name() {
        return org_name;
        }

        public void setOrg_name(String org_name) {
        this.org_name = org_name;
        }

        public String getOrg_type() {
        return org_type;
        }

        public void setOrg_type(String org_type) {
        this.org_type = org_type;
        }

        public String getContact_email() {
        return contact_email;
        }

        public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
        }

        public String getContact_phone() {
        return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
        }


}