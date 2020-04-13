package com.example.demos.db;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity 
public class Users {
 @Id private String username;

  private String email;

  private String pass_hash;
  private String agency;

  public void setnewUser(String name,String mail,String pass){
    setName(name);
    setEmail(mail);
    setpassword(pass);
    setAgency("111333");
  }

  private void setAgency(String agency){
    this.agency = agency;
  }

  public String getAgency(){
    return agency;
  }

  public String getPassword(){
    return pass_hash;
  }

  private void setpassword(String pass){
    this.pass_hash = pass;
  }


  public String getName() {
    return username;
  }

  private void setName(String name) {
    this.username = name;
  }

  public String getEmail() {
    return email;
  }

  private void setEmail(String email) {
    this.email = email;
  }
}