package com.djc.scene.dto;

public class UserDto {
    private String userName;
    private String passWord;
    private String mobileNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
