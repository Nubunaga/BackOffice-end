package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  private String password;

  public void setnewUser(String name,String mail,String pass){
    setEmail(mail);
    setName(name);
    setpassword(pass);
  }

  public Integer getId() {
    return id;
  }

  public String getPassword(){
    return password;
  }
  
  private void setpassword(String pass){
    this.password = pass;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  private void setEmail(String email) {
    this.email = email;
  }
}