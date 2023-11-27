package com.example.firebase;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
    String userName;
    String phoneNumber;
    String groupUser;

    //When dealing with Firebase, always crete no-arguments constructor
    public User() {
    }

    public User(String userName, String phoneNumber, String groupUser) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.groupUser = groupUser;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    @Bindable
    public String getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(String groupUser) {
        this.groupUser = groupUser;
        notifyPropertyChanged(BR.groupUser);
    }
}
