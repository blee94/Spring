package com.blee.bleespring.controller.vo;

import lombok.Getter;

@Getter
public class PracticeVO {
    private String name;
    private String gender;
    private String birth;
    private String interest;

    public String getName(){ return name;}

    public void setName(String name) {this.name = name;}

    public String getGender(){ return gender;}

    public void setGender(String gender) {this.gender = gender;}
    public String getBirth(){ return birth;}

    public void setDate(String birth) {this.birth = birth;}
    public String getInterest(){ return interest;}

    public void setInterest(String interest) {this.interest = interest;}
}
