package com.example.onboarding;

public class StartupClass {
    private int reg_no;
    private String company_name;
    private String phone;
    private String password;
    private String description;

    public StartupClass() {
    }

    public StartupClass(int reg_no, String company_name, String phone, String password, String description) {
        this.reg_no = reg_no;
        this.company_name = company_name;
        this.phone = phone;
        this.password = password;
        this.description = description;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
