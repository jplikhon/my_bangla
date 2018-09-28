package com.example.jplikhon.my_bangla.Model;

/**
 * Created by JP Likhon on 9/24/2018.
 */

public class User {

    private String username;
    private String password;
    private String mailadress;

    public User(){
    }
    public User(String username,String mailadress,String password){
        this.username = username;
        this.mailadress = mailadress;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }
}
