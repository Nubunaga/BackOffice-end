
package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is the hibernate @Entity class that allows hibernate to 
 * wire this class into the database. This thus will create or use a 
 * current table in the db and take the informations from the columns 
 * depending on the attributes in the class; email,pass_hash and agency.
 * 
 * @author Netanel Avraham Eklind
 * @version 1.0
 */


@Entity 
public class Users {
 @Id private String username;

  private String email;

  private String pass_hash;
  private String agency;

  /**
   * This method creates a new user with the given arguments.
   * @param name                String of a name arguemnt
   * @param mail                String of a mail argument
   * @param pass                String of a hashed password argument.
   */
  public void setnewUser(String name,String mail,String pass){
    if (name == null || mail == null || pass == null) throw new IllegalArgumentException("No valid argument given");
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