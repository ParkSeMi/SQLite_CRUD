package com.android.teamcrud;

public class Student {

    // Field
    private int id;
    private String username;
    private String major;
    private int passwd;

    // Constructor


    public Student(int id, String username, String major, int passwd) {
        this.id = id;
        this.username = username;
        this.major = major;
        this.passwd = passwd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getPasswd() {
        return passwd;
    }

    public void setPasswd(int passwd) {
        this.passwd = passwd;
    }
}
