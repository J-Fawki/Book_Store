package com.example.firstandroid_proj;

import java.security.PrivateKey;

public class Users {
    private String Name;
    private String Username;
    private Integer Age;
    private String Password;

    public Users(){

    }

    public Users(String Name, String Username, Integer Age, String Password){
        this.Name = Name;
        this.Username = Username;
        this.Age = Age;
        this.Password = Password;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
