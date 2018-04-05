package com.hwys.helloworld;

/**
 * Created by htetwaiyanswe on 3/10/18.
 */

public class StudentInfo {
    private int idNo, age;
    private String name, address;

    public StudentInfo(){

    }

    public StudentInfo(String _name, int idNo){
        name = _name;
        this.idNo = idNo;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
