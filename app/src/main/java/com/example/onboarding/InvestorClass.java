package com.example.onboarding;

public class InvestorClass {

    private int reg_no;
    private String name;
    private String email;
    private String password;
    private String description;

    public InvestorClass() {
    }

    public InvestorClass(int reg_no, String name, String email, String password, String description) {
        this.reg_no = reg_no;
        this.name = name;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
