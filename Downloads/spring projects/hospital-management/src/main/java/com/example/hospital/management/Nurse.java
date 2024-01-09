package com.example.hospital.management;

public class Nurse {
    private int nurseId;
    private String name;
    private int age;
    private String qualifications;

    public Nurse(int nurseId, String name, int age, String qualifications) {
        this.nurseId = nurseId;
        this.name = name;
        this.age = age;
        this.qualifications = qualifications;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

}
