package com.example.ali.loginregister;

/**
 * Created by zhangshuzhe on 12/7/15.
 */
public class ThisUser {
    static public String name, username, email, reservedBook1,reservedBook2;

    public ThisUser (String name, String username, String email,String reservedBook1,String reservedBook2){
        this.name = name;
        this.username = username;
        this.email = email;
        this.reservedBook1 = reservedBook1;
        this.reservedBook2 = reservedBook2;
    }
}
