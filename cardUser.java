package com.yrrhelp.ourProject;
import java.util.UUID;
public class cardUser {

    private String Userid;
    private String Username;
    private String Password;
    private String Email;

    public cardUser(String Userid, String Username, String Password, String Email) {
        super();
        this.Userid = UUID.randomUUID().toString();
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }


    public String getUserid() {return Userid;}
    public void setUserid(String userid) {Userid = userid;}
    public String getUsername() {return Username;}
    public void setUsername(String username) {Username = username;}
    public String getPassword() {return Password;}
    public void setPassword(String password) {Password = password;}
    public String getEmail() {return Email;}
    public void setEmail(String email) {Email = email;}
}




