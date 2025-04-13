package com.royal.bean;

public class StudentBean {
    private int id;
    private String firstName; 
    private String lastName;  
    private String email;
    private String phone;     
    private String dob;        
    private String gender;
    private String address;
    private String course;
    private String batchTime; 
    private String paymentMode;
    private boolean sports;    
    private boolean music;     
    private boolean debate;    
    private boolean volunteering; 

    public StudentBean() {
    }

    public StudentBean(int id, String firstName, String lastName, String email, String phone, String dob, String gender, String address, String course, String batchTime, String paymentMode, boolean sports, boolean music, boolean debate, boolean volunteering) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.course = course;
        this.batchTime = batchTime;
        this.paymentMode = paymentMode;
        this.sports = sports;
        this.music = music;
        this.debate = debate;
        this.volunteering = volunteering;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBatchTime() {
        return batchTime;
    }

    public void setBatchTime(String batchTime) {
        this.batchTime = batchTime;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isDebate() {
        return debate;
    }

    public void setDebate(boolean debate) {
        this.debate = debate;
    }

    public boolean isVolunteering() {
        return volunteering;
    }

    public void setVolunteering(boolean volunteering) {
        this.volunteering = volunteering;
    }
}
